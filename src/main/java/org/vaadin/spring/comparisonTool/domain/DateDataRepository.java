package org.vaadin.spring.comparisonTool.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface DateDataRepository extends CrudRepository<DateData, Long>{
    List<DateData> findByDate(Date date);

}
