package com.sbp.ollamaExemple.model;

public class ChatResponse {
    private Result result;

    public ChatResponse() {
        // Constructeur par défaut
    }

    public ChatResponse(String errorMessage) {
        this.result = new Result(new Output(errorMessage));
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private Output output;

        public Result() {
            // Constructeur par défaut
        }

        public Result(Output output) {
            this.output = output;
        }

        public Output getOutput() {
            return output;
        }

        public void setOutput(Output output) {
            this.output = output;
        }
    }

    public static class Output {
        private String content;

        public Output() {
            // Constructeur par défaut
        }

        public Output(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
