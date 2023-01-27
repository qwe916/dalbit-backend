package gdsc.skhu.dalbit.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dayplan_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @Column
    private LocalDate localDate;

    @Column
    private int limitMoney;

    @Column
    private int totalSpentMoney;

    @OneToMany(mappedBy = "dayPlan")
    private List<Memo> memos = new ArrayList<>();
}
