package com.wha.hbm.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wha.hbm.config.DataConfig;
import com.wha.hbm.config.WebConfig;
import com.wha.hbm.iservice.CompteService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, DataConfig.class })
public class CompteTest {

	@Autowired
	CompteService CS;
	
	@Test
	@Transactional
	@Rollback(true)
	public void test() {
		assertThat(CS, instanceOf(CompteService.class));
		assertThat(CS.findCompteById(1), instanceOf(CompteService.class));
	}

}
