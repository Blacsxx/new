package com.tedu.store.controller;

import com.tedu.store.controller.ex.FileEmptyException;
import com.tedu.store.controller.ex.FileSizeOutOfLimitException;
import com.tedu.store.controller.ex.FileTypeNotSupportException;
import com.tedu.store.controller.ex.FileUploadException;
import com.tedu.store.entity.User;
import com.tedu.store.service.IUserService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final String UPLOAD_DIR_NAME = "upload";
    private static final long FILE_MAX_SIZE = 5 * 1024 * 1024;
    private static final List<String> FILE_CONTEXT_TYPES = new ArrayList<>();

    static {
        FILE_CONTEXT_TYPES.add("image/png");
        FILE_CONTEXT_TYPES.add("image/jpeg");
        FILE_CONTEXT_TYPES.add("image/jpg");
    }

    @Autowired
    private IUserService userService;

    @PostMapping("/reg.do")
    public ResponseResult<Void> handleReg(User user) throws Exception {
        userService.register(user);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/login.do")
    public ResponseResult<User> handleLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        User user = userService.login(username, password);
        session.setAttribute("id", user.getId());
        session.setAttribute("username", user.getUsername());
        return new ResponseResult<User>(SUCCESS,user);
    }

    @PostMapping("/password.do")
    public ResponseResult<Void> handleChangePassword(@RequestParam("old_password") String oldPassword, @RequestParam("new_password") String newPassword, HttpSession session) {
        userService.changePassword(Integer.valueOf(session.getAttribute("id").toString()), oldPassword, newPassword);
        return new ResponseResult<Void>(SUCCESS);
    }

    @RequestMapping("/info.do")
    public ResponseResult<User> getInfo(HttpSession session) {
        User user = userService.getById(getIdBySession(session));
        return new ResponseResult<User>(SUCCESS, user);
    }

    @PostMapping("/chang_info.do")
    public ResponseResult<Void> changInfo(User user, HttpSession session) {
        Integer id = getIdBySession(session);
        user.setId(id);
        userService.changeInfo(user);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/upload.do")
    public ResponseResult<String> handleUpload(HttpSession session, @RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            throw new FileEmptyException("上传失败,没有选择上传的文件或文件为空");
        }

        if (file.getSize() > FILE_MAX_SIZE) {
            throw new FileSizeOutOfLimitException("上传文件超过大小限制");
        }

        if (!FILE_CONTEXT_TYPES.contains(file.getContentType())){
            throw new FileTypeNotSupportException("文件类型不支持");
        }


        String realPath = session.getServletContext().getRealPath(UPLOAD_DIR_NAME);
        System.out.println(realPath);
        File parent = new File(realPath);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + "" + (new Random().nextInt(900000) + 100000) + substring;
        File dest = new File(parent, fileName);
        try {
            file.transferTo(dest);
            System.out.println("上传完成!");
        } catch (IOException e) {
            throw new FileUploadException("上传失败");
        }
        Integer id = getIdBySession(session);
        String avatar = "/" + UPLOAD_DIR_NAME + "/" + fileName;
        userService.changeAvatar(id, avatar);
        ResponseResult<String> rr = new ResponseResult<>();
        rr.setStatus(200);
        rr.setData(avatar);
        return rr;
    }
}
