package com.gafah.panier.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.gafah.panier.model.Product;

public class PanierServiceControllerTest extends AbstractTest {
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   @Test
	   public void getProductsList() throws Exception {
	      String uri = "/paniers";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Product[] productlist = super.mapFromJson(content, Product[].class);
	      assertTrue(productlist.length > 0);
	   }
	   @Test
	   public void createProduct() throws Exception {
	      String uri = "/paniers";
	      Product product = new Product();
	      product.setId(2l);
	      String inputJson = super.mapToJson(product);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println("content "+content);
//	      assertEquals(content, "Product is created successfully");
	   }
	   @Test
	   public void deleteProduct() throws Exception {
	      String uri = "/products/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println("content "+content);
//	      assertEquals(content, "FORBIDDEN");
	   }
	}