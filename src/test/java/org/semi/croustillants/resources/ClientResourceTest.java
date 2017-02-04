package org.semi.croustillants.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.semi.croustillants.model.payment.PaymentClient;
import org.semi.croustillants.services.ClientService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by raymo on 04/02/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ClientResource.class)
public class ClientResourceTest {

    @Inject
    private MockMvc mvc;

    @MockBean
    private ClientService clientService;

    @Inject
    protected ObjectMapper mapper;

    @Test
    public void getVehicleShouldReturnMakeAndModel() throws Exception {
        final PaymentClient client = new PaymentClient(null, "jack", "daniel", "jack", "daniel", null, null);
        final PaymentClient returnValue = new PaymentClient(42L, client.getFname(), client.getName(), client.getLogin(), client.getPwd(), "qdqsd546qs54d", 100000f);
        given(this.clientService.registerClient(any()))
                .willReturn(returnValue);


        this.mvc.perform(post("/client/register")
                .content(mapper.writeValueAsBytes(client))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(mapper.writeValueAsString(returnValue)));
    }

}
