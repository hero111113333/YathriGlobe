package com.yathriglobe.gateway.jwtFilter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.yathriglobe.gateway.jwtutil.JwtUtil;

import reactor.core.publisher.Mono;

@Component
public class JwtFilter implements GlobalFilter,Ordered
{
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public int getOrder() 
	{
		
		return -1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) 
	{
		
		String path=exchange.getRequest().getURI().getPath();
		
		if(path.startsWith("/auth"))
		{
			return chain.filter(exchange);
		}
		
		String authHeader=exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) 
		{
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
		
		String token=authHeader.substring(7);
		
		try 
		{
            jwtUtil.getClaims(token);
        } 
		catch (Exception e) 
		{
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
		
		String email = jwtUtil.extractEmail(token);

		exchange = exchange.mutate()
		        .request(exchange.getRequest().mutate()
		        .header("X-User-Email", email)
		        .build())
		        .build();

		return chain.filter(exchange);

		
		
		
	}
}
