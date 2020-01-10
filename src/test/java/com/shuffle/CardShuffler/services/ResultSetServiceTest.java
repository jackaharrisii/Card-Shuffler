package com.shuffle.CardShuffler.services;

import com.shuffle.CardShuffler.controllers.ResultSetController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ResultSetServiceTest {

    @InjectMocks
    ResultSetService resultSetService;

    @Mock
    ResultSetController controller;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void show() {
    }

    @Test
    public void create() {
    }

}
