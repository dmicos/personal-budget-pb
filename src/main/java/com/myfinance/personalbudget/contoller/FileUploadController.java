package com.myfinance.personalbudget.contoller;

import com.myfinance.personalbudget.exception.FileStorageException;
import com.myfinance.personalbudget.service.DtoService;
import com.myfinance.personalbudget.service.FileService;
import com.myfinance.personalbudget.service.ReaderCsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

@Controller
public class FileUploadController {
    private final FileService fileService;
    private final ReaderCsvFileService readerCsvFileService;
    private final DtoService dtoService;

    @Autowired
    public FileUploadController(FileService fileService, ReaderCsvFileService readerCsvFileService, DtoService dtoService) {
        this.fileService = fileService;
        this.readerCsvFileService = readerCsvFileService;
        this.dtoService = dtoService;
    }

    @GetMapping("/upload")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file,
                             RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            throw new FileStorageException("No file chosen");
        }
        if (!Objects.equals(file.getContentType(), "text/csv")) {
            throw new FileStorageException("Invalid csv format");
        }


        Instant start = Instant.now();
        {
            File uploadedFile = fileService.upload(file);
            dtoService.importToDb(readerCsvFileService.builderBeanList(uploadedFile));
            fileService.remove(uploadedFile);
        }
        Instant end = Instant.now();
        redirectAttributes.addFlashAttribute("fileName", file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("countRecord", dtoService.getCountRecord());
        redirectAttributes.addFlashAttribute("duplicates", dtoService.getDuplicates());
        redirectAttributes.addFlashAttribute("elapsedTime", Duration.between(start, end).toMillis());

        return "redirect:/upload";
    }
}

