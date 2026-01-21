package uk.co.devfoundry.util;

import uk.co.devfoundry.service.AuditService;
import uk.co.devfoundry.service.FileService;

public class FilePrinter {
    private final FileService files;
    private final AuditService audit;

    public FilePrinter(FileService files, AuditService audit) {
        this.files = files;
        this.audit = audit;
    }

    public String firstLine(String path) {
        audit.recordFileRead(path);
        String content = files.readAll(path);
        return content.lines().findFirst().orElse("");
    }
}

