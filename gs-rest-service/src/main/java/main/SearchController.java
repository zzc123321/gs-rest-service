package main;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.alibaba.fastjson.JSONObject;

import mapper.SearchObjectMapper;
import model.ResultObject;
import model.SearchPager;
import util.rabbitmq.MsgSender;
import util.string.LexemeUtil;

@RestController
public class SearchController {
    @Autowired
    private MsgSender sender;
    @Autowired
    private SearchObjectMapper searchObjectMapper;

    @RequestMapping("/getSearchResult")
    public String getSearchResult(@RequestParam(value = "keyvalue") String keyvalue, HttpServletRequest request) {
	// 设置返回结果集
	SearchPager pager = new SearchPager();
	ResultObject result = new ResultObject();
	// 将输入的关键字分词
	List<String> strList = LexemeUtil.getSegment(keyvalue);
	// 将分词发送给rabbit让后台爬虫消费
	for (String s : strList) {
	    sender.send(s);
	}
	pager.setData(searchObjectMapper.getAll());
	result.setPager(pager);
	
	// 返回json结果集
	Object json = JSONObject.toJSON(result);

	return json.toString();
    }
}
