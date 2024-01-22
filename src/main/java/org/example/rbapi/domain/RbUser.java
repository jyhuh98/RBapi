package org.example.rbapi.domain;

import org.example.rbapi.dto.RbUserDto;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Table(
        indexes = {
                @Index(name = "IDX_RbUser_createdAt", columnList = "createdAt")
                ,@Index(name = "IDX_RbUser_modifiedAt", columnList = "modifiedAt")
                ,@Index(name = "IDX_RbUser_process", columnList = "process")
        }
        , uniqueConstraints= {
        @UniqueConstraint(name = "UQ_RbUser_nick", columnNames = {"nick"})
}
)
@Entity
public class RbUser extends AuditingField{
    @Setter @Column(nullable = false) private String uid;
    @Setter @Column(nullable = false) private String pw;
    @Setter @Column(nullable = false) private String nick;
    @Setter @Column(nullable = false) private String sfrom;
    @Setter @Column(nullable = false) private String process;
    @Setter @Column(nullable = true) private String name;
    @Setter @Column(nullable = true) private String phone;
    @Setter @Column(nullable = true) private String mpic;
    @Setter @Column(nullable = true, length = 10000) private String content; // 본문

    protected RbUser(){}
    private RbUser(String uid, String pw, String nick, String sfrom, String process) {
        this.uid = uid;
        this.pw = pw;
        this.nick = nick;
        this.sfrom = sfrom;
        this.process = process;
    }
    public static RbUser of(String uid, String pw, String nick, String sfrom, String process) {
        return new RbUser(uid, pw, nick, sfrom, process);
    }
    public static RbUser of(String uid, String pw) {
        return new RbUser(uid, pw, "", "", "0");
    }

    public RbUserDto.RbUserAfterCreateDto toAfterCreateDto() {
        return RbUserDto.RbUserAfterCreateDto.builder()
                .id(super.getId())
                .build();
    }
    public RbUserDto.RbUserAfterUpdateDto toAfterUpdateDto() {
        return RbUserDto.RbUserAfterUpdateDto.builder()
                .id(super.getId())
                .deleted(super.getDeleted())
                .build();
    }
}
