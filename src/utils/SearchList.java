package utils;

import java.util.List;

import utils.interfaces.SchoolObjectInterface;

public class SearchList {
  public static <T extends SchoolObjectInterface> T searchObject(List<T> list, String key) {
    return list.stream().filter(obj -> key.equals(obj.getSchoolID())).findFirst().orElse(null);
  }
}
