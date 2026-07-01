package com.pm.billingservice.grpc;

import billing.BillingServiceGrpc.BillingServiceImplBase;
import billing.BillingRequest;
import billing.BillingResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> resopnseObserver){
        log.info("createBillingAccount request received {}", billingRequest.toString());

        //Business Logic

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("1234")
                .setStatus("ACTIVE")
                .build();

        resopnseObserver.onNext(response);
        resopnseObserver.onCompleted();
    }
}
