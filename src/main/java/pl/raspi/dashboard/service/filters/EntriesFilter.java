package pl.raspi.dashboard.service.filters;

import pl.raspi.dashboard.model.WithValidation;

import java.util.List;

public interface EntriesFilter<T extends WithNameIdIssueDate & WithValidation> {

  default boolean hasField(T entry, long filterId) {
    return true;
  }

  default boolean hasObject(T entry, Object filter) {
    return true;
  }

  default boolean hasObjectById(T entry, long objectId) {
    return true;
  }

  default List<T> filterByField(List<T> entries, long filterKey) {
    return entries;
  }

}