package org.example.rbapi.dto;

import org.example.rbapi.domain.RbBoard;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class RbBoardDto {
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardCreateDto {
        @Schema(description = "title", example="title")
        @NotNull
        @NotEmpty
        @Size(max=100)
        private String title;

        @Schema(description = "content", example="content")
        @NotNull
        @NotEmpty
        @Size(max=200)
        private String content;

        public RbBoard toEntity() {
            return RbBoard.of(title, content);
        }
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardAfterCreateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        @NotNull
        @NotEmpty
        @Size(max=32)
        private String id;

        @Schema(description = "title", example="title")
        @Size(max=100)
        private String title;

        @Schema(description = "deleted", example="Y")
        @Size(max=1)
        private String deleted;

        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardAfterUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
        @Schema(description = "deleted", example="Y")
        private String deleted;
        @Schema(description = "title", example="title")
        @Size(max=100)
        private String title;
        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardSelectDto {

        @Schema(description = "id", example="id")
        private String id;
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "deleted", example="N")
        private String deleted;
        @Schema(description = "created_at", example="2024-01-01 00:00:00.000000")
        private String created_at;
        @Schema(description = "modified_at", example="2024-01-01 00:00:00.000000")
        private String modified_at;

    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardListDto {
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }

    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardPagedListDto extends CommonPagedListDto {
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }
    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RbBoardMoreListDto extends CommonMoreListDto {
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }

}
