package com.user.service.Services;

import com.user.service.Clients.InvoiceServiceFeignClient;
import com.user.service.DTOs.InvoiceDto;
import com.user.service.DTOs.InvoiceRequest;
import com.user.service.Exceptions.InvoiceException;
import com.user.service.Exceptions.UserException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceServiceFeignClient invoiceServiceFeignClient;
    private final RetryTemplate retryTemplate;


    public List<InvoiceDto> callInvoiceServiceAndGetInvoiceByUsers(InvoiceRequest invoiceRequest){

        List<InvoiceDto> response;

        try{
            response = retryTemplate.execute((arg)->{
                System.out.println(arg.toString() + " " + (new Date().toString()));
                return invoiceServiceFeignClient.getInvoiceByUsers(invoiceRequest).getBody();
            });
        } catch(InvoiceException invoiceException){
            throw invoiceException;
        } catch(FeignException.ServiceUnavailable e){
            throw new UserException("Downstream service not available.", List.of("Invoices"));
        } catch(FeignException.GatewayTimeout e){
            throw new UserException("Downstream service connection timeout.", List.of("Invoices"));
        } catch (Exception e){
            throw new UserException("Something went wrong.", List.of("Invoices"));
        }

        return response;
    }


    public List<InvoiceDto> callInvoiceServiceAndGetInvoiceByUser(String userId){

        List<InvoiceDto> response;

        try{
            response = retryTemplate.execute((arg)->{
                System.out.println(arg.toString() + " " + (new Date().toString()));
                return invoiceServiceFeignClient.getInvoiceByUser(userId).getBody();
            });
        } catch(InvoiceException invoiceException){
            throw invoiceException;
        } catch(FeignException.ServiceUnavailable e){
            throw new UserException("Downstream service not available.", List.of("Invoices"));
        } catch(FeignException.GatewayTimeout e){
            throw new UserException("Downstream service connection timeout.", List.of("Invoices"));
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new UserException("Something went wrong.", List.of("Invoices"));
        }

        return response;
    }
}
