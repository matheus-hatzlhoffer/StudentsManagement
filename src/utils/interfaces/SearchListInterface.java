package utils.interfaces;

import java.util.List;

public interface SearchListInterface {
  public <T> T searchObject(List<T> list, String key);
}
