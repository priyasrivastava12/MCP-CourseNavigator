package mcp.coursenavigator;

import java.util.List;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoursenavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursenavigatorApplication.class, args);
	}

	@Bean
	public List<ToolCallback> tools(CourseService courseService) {
		return List.of(ToolCallbacks.from(courseService));
	}

}
