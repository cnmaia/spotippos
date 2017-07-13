package br.com.cmaia.service.resource;

public interface ResourceConverter<E, R> {
    E fromResource(R resource);
    R toResource(E entity);
}
