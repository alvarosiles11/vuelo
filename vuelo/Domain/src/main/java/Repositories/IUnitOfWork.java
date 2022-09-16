package Repositories;

import fourteam.http.Exception.HttpException;

public interface IUnitOfWork {
  public void commit() throws HttpException, Exception;
}
