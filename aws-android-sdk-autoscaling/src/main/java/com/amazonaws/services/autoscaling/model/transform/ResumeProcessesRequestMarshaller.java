/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.services.autoscaling.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * StAX request marshaller for ResumeProcessesRequest
 */
public class ResumeProcessesRequestMarshaller implements
        Marshaller<Request<ResumeProcessesRequest>, ResumeProcessesRequest> {

    public Request<ResumeProcessesRequest> marshall(ResumeProcessesRequest resumeProcessesRequest) {
        if (resumeProcessesRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(ResumeProcessesRequest)");
        }

        Request<ResumeProcessesRequest> request = new DefaultRequest<ResumeProcessesRequest>(
                resumeProcessesRequest, "AmazonAutoScaling");
        request.addParameter("Action", "ResumeProcesses");
        request.addParameter("Version", "2011-01-01");

        String prefix;
        if (resumeProcessesRequest.getAutoScalingGroupName() != null) {
            prefix = "AutoScalingGroupName";
            String autoScalingGroupName = resumeProcessesRequest.getAutoScalingGroupName();
            request.addParameter(prefix, StringUtils.fromString(autoScalingGroupName));
        }
        if (resumeProcessesRequest.getScalingProcesses() != null) {
            prefix = "ScalingProcesses";
            java.util.List<String> scalingProcesses = resumeProcessesRequest.getScalingProcesses();
            int scalingProcessesIndex = 1;
            String scalingProcessesPrefix = prefix;
            for (String scalingProcessesItem : scalingProcesses) {
                prefix = scalingProcessesPrefix + ".member." + scalingProcessesIndex;
                if (scalingProcessesItem != null) {
                    request.addParameter(prefix, StringUtils.fromString(scalingProcessesItem));
                }
                scalingProcessesIndex++;
            }
            prefix = scalingProcessesPrefix;
        }

        return request;
    }
}
