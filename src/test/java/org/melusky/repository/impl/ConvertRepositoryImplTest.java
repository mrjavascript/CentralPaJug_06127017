package org.melusky.repository.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.melusky.repository.ConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by mikem on 6/12/2017.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConvertRepositoryImplTest {

    @Autowired
    private ConvertRepository convertRepository;

    @Test
    public void convertToF_Soap() throws Exception {

        assertEquals(new Double(212.0), convertRepository.convertToF_Static(100.0));

    }

}