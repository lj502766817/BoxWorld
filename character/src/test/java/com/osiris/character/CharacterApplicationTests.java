package com.osiris.character;

import com.osiris.character.dao.CharacterDao;
import com.osiris.character.entity.Character;
import com.osiris.character.mapper.CharaterMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CharacterApplicationTests {

    @Before
    public void before(){
        System.out.println("开始测试前");
    }

    @Autowired
    private CharaterMapper charaterMapper;

    @Autowired
    private CharacterDao characterDao;

    @Test
    @Ignore
    public void test() {
        Character character = new Character();
        character.setUserId(123123);
        character.setName("jaja123");
        character.setStatus(1);
        charaterMapper.insert(character);
    }

}
