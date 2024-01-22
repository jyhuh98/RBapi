package org.example.rbapi.domain;

import org.example.rbapi.dto.RbBoardDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title")
})
@Entity
public class RbBoard extends AuditingField {
    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    protected RbBoard(){}
    private RbBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public static RbBoard of(String title, String content) {
        return new RbBoard(title, content);
    }
    public static RbBoard of(String title) {
        return new RbBoard(title, "");
    }

    public RbBoardDto.RbBoardAfterCreateDto toAfterCreateDto() {
        return RbBoardDto.RbBoardAfterCreateDto.builder()
                .id(super.getId())
                .build();
    }
    public RbBoardDto.RbBoardAfterUpdateDto toAfterUpdateDto() {
        return RbBoardDto.RbBoardAfterUpdateDto.builder()
                .id(super.getId())
                .deleted(super.getDeleted())
                .title(getTitle())
                .content(getContent())
                .build();
    }
}
