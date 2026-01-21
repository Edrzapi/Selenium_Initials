package DemoTests;

import org.junit.jupiter.api.Test;
import uk.co.devfoundry.service.AuditService;
import uk.co.devfoundry.service.FileService;
import uk.co.devfoundry.util.FilePrinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class FilePrinterTest {

    @Test
    void returnsFirstLine() {
        // Stub: simple implementation that returns fixed data
        FileService files = path -> "hello\nworld";

        // Stub: no-op (does nothing)
        AuditService audit = path -> {
        };

        FilePrinter cut = new FilePrinter(files, audit);

        assertEquals("hello", cut.firstLine("any.txt"));
    }

    @Test
    void firstLineReadsFileOnceRecordsAutioOnce(){
        //Arrange
        FileService file = mock(FileService.class);
        AuditService audit = mock(AuditService.class);

        when(file.readAll("any.txt")).thenReturn("hello\nworld");

        FilePrinter cut = new FilePrinter(file, audit);

        //Act
        String result = cut.firstLine("any.txt");

        //Assert
        assertEquals("hello", result);
        verify(file, times(1)).readAll("any.txt");
        verifyNoInteractions(file, audit);
    }
}

