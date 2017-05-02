package com.maorlast.datetime.repository;

import com.maorlast.datetime.model.DateTimeModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Maor Last on 02/05/2017.
 */
public interface DateTimeRepository extends CrudRepository<DateTimeModel, String> {
}
