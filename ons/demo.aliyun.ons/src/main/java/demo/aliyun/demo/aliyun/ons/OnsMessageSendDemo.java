package demo.aliyun.demo.aliyun.ons;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsMessageSendRequest;
import com.aliyuncs.ons.model.v20190214.OnsMessageSendResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class OnsMessageSendDemo {

	public static void main(String[] args) {
		DefaultProfile profile = DefaultProfile.getProfile("eu-central-1", System.getenv("ALICLOUD_ACCESS_KEY_ID"),
				System.getenv("ALICLOUD_ACCESS_KEY_SECRET"));
		IAcsClient client = new DefaultAcsClient(profile);

		OnsMessageSendRequest request = new OnsMessageSendRequest();
		request.setSysRegionId("eu-central-1");
		request.setMessage("test01");
		request.setInstanceId("MQ_INST_1331372942856765_Bcbkjyc0");
		request.setTopic("demo");

		try {
			OnsMessageSendResponse response = client.getAcsResponse(request);
			System.out.println(new Gson().toJson(response));
		} catch (ClientException e) {
			System.out.println("ErrCode:" + e.getErrCode());
			System.out.println("ErrMsg:" + e.getErrMsg());
			System.out.println("RequestId:" + e.getRequestId());
		}

	}
}
