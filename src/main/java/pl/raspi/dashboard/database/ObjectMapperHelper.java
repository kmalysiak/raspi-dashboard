package pl.raspi.dashboard.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.DBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ObjectMapperHelper<T> {

  private final Logger logger = LoggerFactory.getLogger(ObjectMapperHelper.class);
  private ObjectMapper jsonMapper;
  private Class<T> entryClass;

  public ObjectMapperHelper(Class<T> entryClass) {
    jsonMapper = new ObjectMapper();
    jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    jsonMapper.registerModule(new JavaTimeModule());
    this.entryClass = entryClass;
  }

  public String toJson(T object) {
    try {
      return jsonMapper.writeValueAsString(object);
    } catch (JsonProcessingException ex) {
      logger.warn(" from toJson: "
          + ExceptionMsg.INTERNAL_PROCESSING_ERROR, ex);
      throw new DbException(ExceptionMsg.INTERNAL_PROCESSING_ERROR, ex);
    }
  }

  public T toObject(String json) {
    try {
      return jsonMapper.readValue(json, entryClass);
    } catch (IOException ex) {
      logger.warn(" from toObject: "
          + ExceptionMsg.INTERNAL_PROCESSING_ERROR, ex);
      throw new DbException(ExceptionMsg.INTERNAL_PROCESSING_ERROR, ex);
    }
  }

  public T toObject(DBObject dbObject) {
    dbObject.removeField("_id");
    return toObject(dbObject.toString());
  }

  public String idToJson(long id) {
    try {
      return jsonMapper.writeValueAsString(id);
    } catch (JsonProcessingException ex) {
      throw new DbException(ExceptionMsg.INTERNAL_PROCESSING_ERROR, ex);
      //TODO add logging.
    }
  }

  public long jsonToId(String json) {
    try {
      return jsonMapper.readValue(json, new TypeReference<Long>() {
      });
    } catch (IOException ex) {
      throw new DbException(ExceptionMsg.INTERNAL_PROCESSING_ERROR, ex);
      //TODO add logging.
    }
  }

}

