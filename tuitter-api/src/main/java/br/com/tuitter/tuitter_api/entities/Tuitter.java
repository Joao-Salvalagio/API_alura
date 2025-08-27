package br.com.tuitter.tuitter_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Tuitter {

    public enum TuitterType{
        POST, REPOST, QUOTE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 42)
    private String content;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(columnDefinition = "enum('POST', 'REPOST', 'QUOTE')")
    private TuitterType type;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

    @JoinColumn(name= "post_tuitter_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tuitter postTuitter;

    @NotNull
    private LocalDateTime createdAt;

    @Deprecated
    protected Tuitter() {
    }

    public Tuitter(Long id, String content, TuitterType type, User author) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public TuitterType getType() {
        return type;
    }

    public User getAuthor() {
        return author;
    }

    public Optional<Tuitter> getPostTuitter() {
        return Optional.ofNullable(postTuitter);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
