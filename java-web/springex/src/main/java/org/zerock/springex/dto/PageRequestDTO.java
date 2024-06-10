package org.zerock.springex.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String[] types = new String[] {};
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    private String link;

    public int getSkip() {
        return (page - 1) * 10;
    }

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=").append(this.page)
                .append("&size=").append(this.size);

        if (finished) {
            builder.append("&finished=on");
        }

        if (keyword != null) {
            try {
                builder.append("&keyword=").append(URLEncoder.encode(keyword, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if (from != null) {
            builder.append("&from=").append(from.toString());
        }

        if (to != null) {
            builder.append("&to=").append(to.toString());
        }

        return builder.toString();
    }

    public boolean checkType(String type) {
        if (type == null || types.length == 0) {
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
