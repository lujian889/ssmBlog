package com.we.weblog.service;

import com.we.weblog.domain.UploadPicture;
import com.we.weblog.service.Impl.FileService;
import com.we.weblog.tool.FileTools;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;


@Service
public class FileServiceImpl implements FileService{
    @Override
    public UploadPicture loadPicture(HttpServletRequest request) throws Exception {
        String url = "";
        UploadPicture pic = new UploadPicture();
        try {
             url = FileTools.uploadPicture(request);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("update error");
        }

        if("".equals(url)){
            pic.setSuccess(0);
            pic.setUrlPath("");
            pic.setUrlPath("Upload fail");
            return pic;
        }
        pic.setSuccess(1);
        pic.setUrlPath(url);
        pic.setUrlPath("Upload success");

        return pic;

    }


}