package tm.email.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import tm.email.model.account.Account;
import tm.email.model.account.AccountRoot;
import tm.email.model.domain.DomainRoot;
import tm.email.model.message.MessageRoot;
import tm.email.model.messageId.MessageIdRoot;
import tm.email.model.token.Token;
import tm.email.model.token.TokenRoot;

import java.io.IOException;

public class Tempomeilo {

    private final String BASE_URI = "https://api.mail.tm/";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_CONTENT_TYPE_VALUE = "application/ld+json; charset=utf-8";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public DomainRoot getDomains(Integer pageNumber) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(BASE_URI + "domains");
        uriBuilder.setParameter("page", pageNumber.toString());
        HttpGet request = new HttpGet(uriBuilder.build());
        request.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);

        ObjectMapper mapper = new ObjectMapper();

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return mapper.readValue(EntityUtils.toString(entity), DomainRoot.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AccountRoot getAccount(String address, String password) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(BASE_URI + "accounts");
        HttpPost request = new HttpPost(uriBuilder.build());
        request.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);

        ObjectMapper mapper = new ObjectMapper();
        Account account = new Account(address, password);
        String json = mapper.writeValueAsString(account);
        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return mapper.readValue(EntityUtils.toString(responseEntity), AccountRoot.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TokenRoot getToken(String address, String password) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(BASE_URI + "token");
        HttpPost request = new HttpPost(uriBuilder.build());
        request.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);

        ObjectMapper mapper = new ObjectMapper();
        Token token = new Token(address, password);
        String json = mapper.writeValueAsString(token);
        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return mapper.readValue(EntityUtils.toString(responseEntity), TokenRoot.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MessageRoot getMessages(String token, Integer count) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(BASE_URI + "messages");
        uriBuilder.setParameter("page", count.toString());
        HttpGet request = new HttpGet(uriBuilder.build());
        request.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        ObjectMapper mapper = new ObjectMapper();

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return mapper.readValue(EntityUtils.toString(entity), MessageRoot.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MessageIdRoot getMessageById(String id, String token) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(BASE_URI + "messages/" + id);
        HttpGet request = new HttpGet(uriBuilder.build());
        request.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        ObjectMapper mapper = new ObjectMapper();

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return mapper.readValue(EntityUtils.toString(entity), MessageIdRoot.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws IOException {
        httpClient.close();
    }
}
