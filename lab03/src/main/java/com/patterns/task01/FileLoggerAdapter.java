package com.patterns.task01;

/**
 * Adapter: adapts FileWriter to behave like Logger.
 * Logger interface -> FileWriter implementation.
 */
public class FileLoggerAdapter extends Logger {
    private final FileWriter fileWriter;

    public FileLoggerAdapter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void log(String message) {
        super.log(message);
        fileWriter.writeLine("[LOG]   " + message);
    }

    @Override
    public void error(String message) {
        super.error(message);
        fileWriter.writeLine("[ERROR] " + message);
    }

    @Override
    public void warn(String message) {
        super.warn(message);
        fileWriter.writeLine("[WARN]  " + message);
    }

    public String getFileContent() { return fileWriter.getContent(); }
    public String getFileName()    { return fileWriter.getFileName(); }
}
