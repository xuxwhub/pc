package com.dunshan.biz.client;

import com.dunshan.biz.model.User;
import com.dunshan.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xuxinwei
 * @create 2019-10-20
 */
@FeignClient(name = "PD-SERVICE")
@Component
public interface PDClient {

  @PostMapping("/pd/add")
  ResultVO<Boolean> add(@RequestBody User user);

  @PostMapping("/pd/update")
  ResultVO<Boolean> update(@RequestBody User user);

  @PostMapping("/pd/delete/{id}")
  ResultVO<Boolean> delete(@PathVariable("id") String id);

  @GetMapping("/pd/query/{id}")
  ResultVO<User> get(@PathVariable("id") String id);

}
