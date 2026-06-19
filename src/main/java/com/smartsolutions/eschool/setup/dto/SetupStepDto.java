package com.smartsolutions.eschool.setup.dto;

/**
 * DTO representing an individual setup step and its status.
 */
public class SetupStepDto {
    private String code;
    private String title;
    private SetupStepStatus status;
    private String route;

    public SetupStepDto() {}

    public SetupStepDto(String code, String title, SetupStepStatus status, String route) {
        this.code = code;
        this.title = title;
        this.status = status;
        this.route = route;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public SetupStepStatus getStatus() { return status; }
    public void setStatus(SetupStepStatus status) { this.status = status; }

    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String code;
        private String title;
        private SetupStepStatus status;
        private String route;

        public Builder code(String code) { this.code = code; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder status(SetupStepStatus status) { this.status = status; return this; }
        public Builder route(String route) { this.route = route; return this; }
        public SetupStepDto build() { return new SetupStepDto(code, title, status, route); }
    }
}
