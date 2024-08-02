package tm.email.model.messageId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import tm.email.model.message.From;
import tm.email.model.message.To;


import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageIdRoot {
    @JsonProperty("@context")
    public String context;

    @JsonProperty("@id")
    public String idMessage;

    @JsonProperty("@type")
    public String type;

    public String id;
    public String accountId;
    public String msgid;
    public From from;
    public List<To> to;
    public List<Object> cc;
    public List<Object> bcc;
    public String subject;
    public boolean seen;
    public boolean flagged;
    public boolean isDeleted;

    @JsonIgnore
    public List<Object> verifications;

    public boolean retention;
    public Date retentionDate;
    public String text;
    public List<String> html;
    public boolean hasAttachments;
    public List<Object> attachments;
    public int size;
    public String downloadUrl;
    public Date createdAt;
    public Date updatedAt;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public List<To> getTo() {
        return to;
    }

    public void setTo(List<To> to) {
        this.to = to;
    }

    public List<Object> getCc() {
        return cc;
    }

    public void setCc(List<Object> cc) {
        this.cc = cc;
    }

    public List<Object> getBcc() {
        return bcc;
    }

    public void setBcc(List<Object> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<Object> getVerifications() {
        return verifications;
    }

    public void setVerifications(List<Object> verifications) {
        this.verifications = verifications;
    }

    public boolean isRetention() {
        return retention;
    }

    public void setRetention(boolean retention) {
        this.retention = retention;
    }

    public Date getRetentionDate() {
        return retentionDate;
    }

    public void setRetentionDate(Date retentionDate) {
        this.retentionDate = retentionDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getHtml() {
        return html;
    }

    public void setHtml(List<String> html) {
        this.html = html;
    }

    public boolean isHasAttachments() {
        return hasAttachments;
    }

    public void setHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
