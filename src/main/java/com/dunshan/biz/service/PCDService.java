package com.dunshan.biz.service;

import com.dunshan.biz.client.PDClient;
import com.dunshan.biz.model.User;
import com.dunshan.common.ErpConstants;
import com.dunshan.common.exception.BusinessErrorException;
import com.dunshan.common.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuxinwei
 * @create 2019-11-18
 */
@Service
public class PCDService {

  private static final Logger logger = LoggerFactory.getLogger(PCDService.class);

  @Autowired
  private PCService pcService;

  @Autowired
  private PDClient pdClient;


  public User getById(String id) {
    User result = pcService.getById(id);
    ResultVO<User> pbUser = pdClient.get(id);
    logger.info("pcClient get result: " + pbUser);
    return result;
  }

  @Transactional
  public Boolean add(User user) {
    Boolean result = pcService.add(user);
    ResultVO<Boolean> pbResult = pdClient.add(user);
    logger.info("pcClient add result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pcClient add error !");
    }
    return result;
  }

  @Transactional
  public Boolean update(User user) {
    Boolean result = pcService.update(user);
    ResultVO<Boolean> pbResult = pdClient.update(user);
    logger.info("pcClient update result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pcClient update error !");
    }
    return result;
  }

  @Transactional
  public Boolean deleteById(String id) {
    Boolean result = pcService.deleteById(id);
    ResultVO<Boolean> pbResult = pdClient.delete(id);
    logger.info("pcClient delete result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pcClient delete error !");
    }
    return result;
  }


}
