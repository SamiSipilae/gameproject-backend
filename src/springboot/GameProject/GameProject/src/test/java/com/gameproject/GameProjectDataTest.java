package com.gameproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gameproject.level.Level;
import com.gameproject.level.LevelJDBCTemplate;
import com.gameproject.session.SessionJDBCTemplate;
import com.gameproject.user.UserJDBCTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("beans.xml")
public class GameProjectDataTest {
	@Autowired
	private UserJDBCTemplate userJDBCTemplate;
	@Autowired
	private SessionJDBCTemplate sessionJDBCTemplate;
	@Autowired
	private LevelJDBCTemplate levelJDBCTemplate;


    @Test
    public void shouldreturnuser() throws Exception {
    	List<Level> levels = levelJDBCTemplate.listLevels();
    	assertThat(levels).isNotNull();
    }
}