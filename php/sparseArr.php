<?php
function httpGet($url)
{
    $ch = curl_init();//c初始化一个cURL会话
    curl_setopt($ch, CURLOPT_URL, $url);//将URL设置为我们需要的URL
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
    $output = curl_exec($ch);//获取json返回数据
    curl_close($ch);
    $output = json_decode($output, true);//将获取到的json转化成php数组
    /*echo "<pre>";
    print_r($output);
    echo "<pre>";*/
    $retStr = "您查询的城市：" .$output['results'][0]['location']['name'] . "\n" . "今日天气：" .$output['results'][0]['daily'][0]['text_day']
        . "\n" . "温度：" .$output['results'][0]['daily'][0]['high'] ."摄氏度";
    return $output;

}

// 心知天气接口调用凭据
$key = 'SHiLkF0musFeDhflk'; // 测试用 key，请更换成您自己的 Key
$uid = 'PQcENr2EF-9iQCh_X'; // 测试用 用户 ID，请更换成您自己的用户 ID
// 参数
$api = 'https://api.seniverse.com/v3/weather/daily.json'; // 接口地址
$location = '广东省汕头市'; // 城市名称。除拼音外，还可以使用 v3 id、汉语等形式

// 生成签名。文档：https://www.seniverse.com/doc#sign
$param = [
    'ts' => time(),
    'ttl' => 300,
    'uid' => $uid,
];
$sig_data = http_build_query($param); // http_build_query 会自动进行 url 编码
// 使用 HMAC-SHA1 方式，以 API 密钥（key）对上一步生成的参数字符串（raw）进行加密，然后 base64 编码
$sig = base64_encode(hash_hmac('sha1', $sig_data, $key, TRUE));

// 拼接 url 中的 get 参数。文档：https://www.seniverse.com/doc#daily
$param['sig'] = $sig; // 签名
$param['location'] = $location;
$param['start'] = 0; // 开始日期。0 = 今天天气
$param['days'] = 1; // 查询天数，1 = 只查一天

// 构造 url
$url = $api . '?' . http_build_query($param);

$message=httpGet($url);
$weather=$message['results'][0]['daily'][0]['text_day'];
$temperature=$message['results'][0]['daily'][0]['high'];
echo $weather;
echo $temperature;