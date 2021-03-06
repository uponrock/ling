package com.jyb.email;

import com.jyb.pojo.MailInfo;
import com.jyb.util.MailSendUtil;

public class Demo{
	public static void main(String[] args) {
		Demo de = new Demo();
		de.send();
	}
	//单发
	public void send(){
        String mail = "acgnwang@qq.com"; //发送对象的邮箱
        String title = "我有一句话跟你说";
        String html = "<!DOCTYPE html>";
        html += "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";
        html += "<title>Insert title here</title>";
        html += "</head><body>";
        html += "<div style=\"width:600px;height:400px;margin:50px auto;\">";
        html += "<h1>我来看看邮件是否发送成功呢</h1><br/><br/>";
        html += "<p>下面是通过该协议可以创建一个指向电子邮件地址的超级链接，通过该链接可以在Internet中发送电子邮件</p><br/>";
        html += "<a href=\"mailto:huntereagle@foxmail.com?subject=test&cc=huntertochen@163.com&body=use mailto sample\">send mail</a>";
        html += "</div>";
        html += "</body></html>";
        MailInfo info = new MailInfo();
        info.setToAddress(mail);
        info.setSubject(title);
        //info.setContent(html);
        Demo dd = new Demo();
        StringBuilder msg = dd.createEmail();
        info.setContent(msg.toString());
        new Demo().SendMail(info);
    }
	//群发
	public void sendalluer(){
        String[] address={"acgnwang@qq.com","745514499@qq.com"};
        String title = "我有一句话跟你说";
        String html = "<!DOCTYPE html>";
        html += "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";
        html += "<title>Insert title here</title>";
        html += "</head><body>";
        html += "<div style=\"width:600px;height:400px;margin:50px auto;\">";
        html += "<h1>我来看看邮件是否发送成功呢</h1><br/><br/>";
        html += "<p>下面是通过该协议可以创建一个指向电子邮件地址的超级链接，通过该链接可以在Internet中发送电子邮件</p><br/>";
        html += "<a href=\"mailto:huntereagle@foxmail.com?subject=test&cc=huntertochen@163.com&body=use mailto sample\">send mail</a>";
        html += "</div>";
        html += "</body></html>";
        MailInfo info = new MailInfo();
        info.setAddress(address);
        info.setSubject(title);
        info.setContent(html);
        new Demo().SendAllMail(info);
    }
	
	
	
	
	@SuppressWarnings("static-access")
	public  void SendMail(MailInfo mailInfo) {
		  // 发送邮件
		  MailSendUtil sms = new MailSendUtil();
		  // 发送文体格式
		  try {
			sms.sendHtmlMail(mailInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  System.out.println("邮件发送完毕");
		}
		@SuppressWarnings("static-access")
		public  void SendAllMail(MailInfo mailInfo) {
			  // 发送邮件
			MailSendUtil sms = new MailSendUtil();
			  // 发送文体格式
			  try {
					sms.sendHtmlMailalluser(mailInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			  System.out.println("邮件发送完毕");
		}
		
		public StringBuilder createEmail() {
	        StringBuilder emailContent = new StringBuilder("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>快来买桃子</title><style type='text/css'>        .container{            font-family: 'Microsoft YaHei';            width: 600px;            margin: 0 auto;            padding: 8px;            border: 3px dashed #db303f;            border-radius: 6px;        }        .title{            text-align: center;            color: #db303f;        }        .content{            text-align: justify;            color: #717273;            font-weight: 600;        }        footer{            text-align: right;            color: #db303f;            font-weight: 600;            font-size: 18px;        }</style></head><body><div class='container'><h2 class='title'>好吃的桃子</h2><p class='content'>桃子含有维生素A、维生素B和维生素C,儿童多吃桃子可使身体健康成长,因为桃子含有的多种维生索可以直接强化他们的身体和智力。</p><footer>联系桃子：11110000</footer></div></body></html>");
	        return emailContent;
	    }
}
