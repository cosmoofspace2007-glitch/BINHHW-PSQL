package Baiss4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseResponseV2
{
    private Long id;
    private String title;
    private CourseStatus status;
}
