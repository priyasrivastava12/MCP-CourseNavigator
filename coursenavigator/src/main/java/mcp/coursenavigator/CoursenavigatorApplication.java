package mcp.coursenavigator;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import org.springframework.ai.tool.annotation.Tool;

@SpringBootApplication
public class CoursenavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursenavigatorApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider courseTools(CourseService courseService) {
		return MethodToolCallbackProvider.builder().toolObjects(courseService).build();
	}

}
