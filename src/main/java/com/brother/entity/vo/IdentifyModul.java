package com.brother.entity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class IdentifyModul implements Serializable {
    private String ext;              //用户的 session 内容，腾讯 server 回包中会原样返回，可选字段，不需要就填空
    private String extend;           //短信码号扩展号，格式为纯数字串，其他格式无效。默认没有开通
    private List<String> params;     //模板参数
    private String sig;              //App 凭证
    private String sign;             //短信签名
    private Object tel;               //国际电话号码
    private Integer time;             //请求发起时间
    private Integer tpl_id;           //模板ID

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Object getTel() {
        return tel;
    }

    public void setTel(Object tel) {
        this.tel = tel;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTpl_id() {
        return tpl_id;
    }

    public void setTpl_id(Integer tpl_id) {
        this.tpl_id = tpl_id;
    }

    @Override
    public String toString() {
        return "IdentifyModul{" +
                "ext='" + ext + '\'' +
                ", extend='" + extend + '\'' +
                ", params=" + params +
                ", sig='" + sig + '\'' +
                ", sign='" + sign + '\'' +
                ", tel=" + tel +
                ", time=" + time +
                ", tpl_id=" + tpl_id +
                '}';
    }


    /**
     * 随机生成6位自定义验证码
     * @return  验证码
     */
    public static String randomForIdentify(){
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i =0;i<6;i++){
            Integer num = ran.nextInt(10);
            sb.append(num+"");
        }
        return sb.toString();
    }


}
