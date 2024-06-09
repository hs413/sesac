package org.zerock.springex.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class TodoDTO {
    private Long tno;

    private String title;

    private LocalDate dueDate;

    private Boolean finished;

    private String writer;
}
