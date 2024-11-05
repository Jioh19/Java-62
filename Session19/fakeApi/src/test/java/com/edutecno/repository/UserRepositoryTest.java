package com.edutecno.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import com.edutecno.model.ListPeople;

class UserRepositoryTest {

	static final String url = "";
	@Mock
	ListPeople lista;
	
	MockedStatic<UserRepository> repo = mockStatic(UserRepository.class);
	
	@Test
	void testFetchFromApi() {
		when(UserRepository.fetchFromApi(url, ListPeople.class)).thenReturn(lista);
		assertEquals(UserRepository.fetchFromApi(url, ListPeople.class), lista);
	}

}
