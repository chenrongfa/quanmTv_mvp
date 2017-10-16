package com.yichen.mmq.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class AppStart {

	private List<AndroidstartBean> androidstart;
	@SerializedName("ios-start")
	private List<IosstartBean> iosstart;
	@SerializedName("app-focus")
	private List<AppfocusBean> appfocus;
	private List<AppFocusCheckBean> appFocusCheck;
	@SerializedName("ios-focus")
	private List<IosfocusBean> iosfocus;
	@SerializedName("ipad-start")
	private List<?> ipadstart;
	@SerializedName("ios-start-test")
	private List<IosstarttestBean> iosstarttest;
	@SerializedName("ios-focus-test")
	private List<IosfocustestBean> iosfocustest;

	public List<AndroidstartBean> getAndroidstart() {
		return androidstart;
	}

	public void setAndroidstart(List<AndroidstartBean> androidstart) {
		this.androidstart = androidstart;
	}

	public List<IosstartBean> getIosstart() {
		return iosstart;
	}

	public void setIosstart(List<IosstartBean> iosstart) {
		this.iosstart = iosstart;
	}

	public List<AppfocusBean> getAppfocus() {
		return appfocus;
	}

	public void setAppfocus(List<AppfocusBean> appfocus) {
		this.appfocus = appfocus;
	}

	public List<AppFocusCheckBean> getAppFocusCheck() {
		return appFocusCheck;
	}

	public void setAppFocusCheck(List<AppFocusCheckBean> appFocusCheck) {
		this.appFocusCheck = appFocusCheck;
	}

	public List<IosfocusBean> getIosfocus() {
		return iosfocus;
	}

	public void setIosfocus(List<IosfocusBean> iosfocus) {
		this.iosfocus = iosfocus;
	}

	public List<?> getIpadstart() {
		return ipadstart;
	}

	public void setIpadstart(List<?> ipadstart) {
		this.ipadstart = ipadstart;
	}

	public List<IosstarttestBean> getIosstarttest() {
		return iosstarttest;
	}

	public void setIosstarttest(List<IosstarttestBean> iosstarttest) {
		this.iosstarttest = iosstarttest;
	}

	public List<IosfocustestBean> getIosfocustest() {
		return iosfocustest;
	}

	public void setIosfocustest(List<IosfocustestBean> iosfocustest) {
		this.iosfocustest = iosfocustest;
	}

	public static class AndroidstartBean {
		/**
		 * id : 1397
		 * title : MSI季中冠军赛
		 * thumb : http://image.quanmin.tv/8f67ddb5c59e73fbd2e048a22d55e53djpg
		 * link : http://www.quanmin.tv/177
		 * create_at : 2016-08-08 16:07:29
		 * status : 1
		 * fk :
		 * subtitle :
		 * content :
		 * ext : {"type":"html","time":"3","start_time":1483242940,"end_time":1484927999}
		 * slot_id : 111
		 * priority : 3
		 */

		private int id;
		private String title;
		private String thumb;
		private String link;
		private String create_at;
		private int status;
		private String fk;
		private String subtitle;
		private String content;
		private ExtBean ext;
		private int slot_id;
		private int priority;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getCreate_at() {
			return create_at;
		}

		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getFk() {
			return fk;
		}

		public void setFk(String fk) {
			this.fk = fk;
		}

		public String getSubtitle() {
			return subtitle;
		}

		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public ExtBean getExt() {
			return ext;
		}

		public void setExt(ExtBean ext) {
			this.ext = ext;
		}

		public int getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(int slot_id) {
			this.slot_id = slot_id;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public static class ExtBean {
			/**
			 * type : html
			 * time : 3
			 * start_time : 1483242940
			 * end_time : 1484927999
			 */

			private String type;
			private String time;
			private int start_time;
			private int end_time;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getTime() {
				return time;
			}

			public void setTime(String time) {
				this.time = time;
			}

			public int getStart_time() {
				return start_time;
			}

			public void setStart_time(int start_time) {
				this.start_time = start_time;
			}

			public int getEnd_time() {
				return end_time;
			}

			public void setEnd_time(int end_time) {
				this.end_time = end_time;
			}
		}
	}

	public static class IosstartBean {
		/**
		 * id : 530
		 * title : MSI季中冠军赛
		 * thumb : http://image.quanmin.tv/a08c415684ca2853a8a7259e1f19be00jpg
		 * link : http://www.quanmin.tv/177
		 * create_at : 2016-04-12 12:49:49
		 * status : 1
		 * fk :
		 * subtitle :
		 * content :
		 * ext : {"type":"html","time":"3","start_time":1483242940,"end_time":1484927999}
		 * slot_id : 112
		 * priority : 0
		 */

		private int id;
		private String title;
		private String thumb;
		private String link;
		private String create_at;
		private int status;
		private String fk;
		private String subtitle;
		private String content;
		private ExtBeanX ext;
		private int slot_id;
		private int priority;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getCreate_at() {
			return create_at;
		}

		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getFk() {
			return fk;
		}

		public void setFk(String fk) {
			this.fk = fk;
		}

		public String getSubtitle() {
			return subtitle;
		}

		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public ExtBeanX getExt() {
			return ext;
		}

		public void setExt(ExtBeanX ext) {
			this.ext = ext;
		}

		public int getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(int slot_id) {
			this.slot_id = slot_id;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public static class ExtBeanX {
			/**
			 * type : html
			 * time : 3
			 * start_time : 1483242940
			 * end_time : 1484927999
			 */

			private String type;
			private String time;
			private int start_time;
			private int end_time;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getTime() {
				return time;
			}

			public void setTime(String time) {
				this.time = time;
			}

			public int getStart_time() {
				return start_time;
			}

			public void setStart_time(int start_time) {
				this.start_time = start_time;
			}

			public int getEnd_time() {
				return end_time;
			}

			public void setEnd_time(int end_time) {
				this.end_time = end_time;
			}
		}
	}

	public static class AppfocusBean {
		/**
		 * title : 阿怡：王者一日游
		 * link : quanmin://mobile.app/liveroom?live=8832533
		 * fk : 8832533
		 * slot_id : 113
		 * ext : {"type":"play"}
		 * link_object : {"no":"8832533","nick":"阿怡丶全民","avatar":"http://a.img.shouyintv
		 * .cn/hnmx201-normal","follow":"766014","uid":"8832533","rectifyType":"0",
		 * "play_at":"2017-09-20 18:23:20","liveId":"21877663","screen":0,"danger":"0",
		 * "views":"2728","intro":"","videoQuality":"234","thumb":"http://image.quanmin
		 * .tv/2af345492a53f8fcde60a17936bdb066jpg","stream":"http://flv.quanmin
		 * .tv/live/8832533_L3.flv","position":"外太空","announcement":"",
		 * "updatetime":"2017-09-20 18:23:04","channelId":"0","id":"101398",
		 * "video":"http://thumb.quanmin.tv/8832533.mp4?t=1505906100","slug":"",
		 * "category_id":"17","cover":"8832533-1505906345-51.jpg","status":"2",
		 * "recommend_image":"http://image.quanmin
		 * .tv/68377681dd4e79a8292daaa3c4ee4b36jpg","weight":"0",
		 * "start_time":"1505903000.691","check":"1","priv":"0","category_name":"王者荣耀",
		 * "title":"阿怡：王者一日游","source":"ws","last_play_at":"","landscape":"1",
		 * "view":"490875","app_shuffling_image":"http://image.quanmin
		 * .tv/2af345492a53f8fcde60a17936bdb066jpg",
		 * "recommend_new_image":"http://static01.quanmin
		 * .tv/201707/1501497382110ae624b1ed5247d6a81314428b92a7964.jpg",
		 * "categoryId":"17","hidden":false,"play_status":true,"love_cover":""}
		 * thumb : http://image.quanmin.tv/2af345492a53f8fcde60a17936bdb066jpg
		 */

		private String title;
		private String link;
		private String fk;
		private int slot_id;
		private ExtBeanXX ext;
		private LinkObjectBean link_object;
		private String thumb;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getFk() {
			return fk;
		}

		public void setFk(String fk) {
			this.fk = fk;
		}

		public int getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(int slot_id) {
			this.slot_id = slot_id;
		}

		public ExtBeanXX getExt() {
			return ext;
		}

		public void setExt(ExtBeanXX ext) {
			this.ext = ext;
		}

		public LinkObjectBean getLink_object() {
			return link_object;
		}

		public void setLink_object(LinkObjectBean link_object) {
			this.link_object = link_object;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public static class ExtBeanXX {
			/**
			 * type : play
			 */

			private String type;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public static class LinkObjectBean {
			/**
			 * no : 8832533
			 * nick : 阿怡丶全民
			 * avatar : http://a.img.shouyintv.cn/hnmx201-normal
			 * follow : 766014
			 * uid : 8832533
			 * rectifyType : 0
			 * play_at : 2017-09-20 18:23:20
			 * liveId : 21877663
			 * screen : 0
			 * danger : 0
			 * views : 2728
			 * intro :
			 * videoQuality : 234
			 * thumb : http://image.quanmin.tv/2af345492a53f8fcde60a17936bdb066jpg
			 * stream : http://flv.quanmin.tv/live/8832533_L3.flv
			 * position : 外太空
			 * announcement :
			 * updatetime : 2017-09-20 18:23:04
			 * channelId : 0
			 * id : 101398
			 * video : http://thumb.quanmin.tv/8832533.mp4?t=1505906100
			 * slug :
			 * category_id : 17
			 * cover : 8832533-1505906345-51.jpg
			 * status : 2
			 * recommend_image : http://image.quanmin
			 * .tv/68377681dd4e79a8292daaa3c4ee4b36jpg
			 * weight : 0
			 * start_time : 1505903000.691
			 * check : 1
			 * priv : 0
			 * category_name : 王者荣耀
			 * title : 阿怡：王者一日游
			 * source : ws
			 * last_play_at :
			 * landscape : 1
			 * view : 490875
			 * app_shuffling_image : http://image.quanmin
			 * .tv/2af345492a53f8fcde60a17936bdb066jpg
			 * recommend_new_image : http://static01.quanmin
			 * .tv/201707/1501497382110ae624b1ed5247d6a81314428b92a7964.jpg
			 * categoryId : 17
			 * hidden : false
			 * play_status : true
			 * love_cover :
			 */

			private String no;
			private String nick;
			private String avatar;
			private String follow;
			private String uid;
			private String rectifyType;
			private String play_at;
			private String liveId;
			private int screen;
			private String danger;
			private String views;
			private String intro;
			private String videoQuality;
			private String thumb;
			private String stream;
			private String position;
			private String announcement;
			private String updatetime;
			private String channelId;
			private String id;
			private String video;
			private String slug;
			private String category_id;
			private String cover;
			private String status;
			private String recommend_image;
			private String weight;
			private String start_time;
			private String check;
			private String priv;
			private String category_name;
			private String title;
			private String source;
			private String last_play_at;
			private String landscape;
			private String view;
			private String app_shuffling_image;
			private String recommend_new_image;
			private String categoryId;
			private boolean hidden;
			private boolean play_status;
			private String love_cover;

			public String getNo() {
				return no;
			}

			public void setNo(String no) {
				this.no = no;
			}

			public String getNick() {
				return nick;
			}

			public void setNick(String nick) {
				this.nick = nick;
			}

			public String getAvatar() {
				return avatar;
			}

			public void setAvatar(String avatar) {
				this.avatar = avatar;
			}

			public String getFollow() {
				return follow;
			}

			public void setFollow(String follow) {
				this.follow = follow;
			}

			public String getUid() {
				return uid;
			}

			public void setUid(String uid) {
				this.uid = uid;
			}

			public String getRectifyType() {
				return rectifyType;
			}

			public void setRectifyType(String rectifyType) {
				this.rectifyType = rectifyType;
			}

			public String getPlay_at() {
				return play_at;
			}

			public void setPlay_at(String play_at) {
				this.play_at = play_at;
			}

			public String getLiveId() {
				return liveId;
			}

			public void setLiveId(String liveId) {
				this.liveId = liveId;
			}

			public int getScreen() {
				return screen;
			}

			public void setScreen(int screen) {
				this.screen = screen;
			}

			public String getDanger() {
				return danger;
			}

			public void setDanger(String danger) {
				this.danger = danger;
			}

			public String getViews() {
				return views;
			}

			public void setViews(String views) {
				this.views = views;
			}

			public String getIntro() {
				return intro;
			}

			public void setIntro(String intro) {
				this.intro = intro;
			}

			public String getVideoQuality() {
				return videoQuality;
			}

			public void setVideoQuality(String videoQuality) {
				this.videoQuality = videoQuality;
			}

			public String getThumb() {
				return thumb;
			}

			public void setThumb(String thumb) {
				this.thumb = thumb;
			}

			public String getStream() {
				return stream;
			}

			public void setStream(String stream) {
				this.stream = stream;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position;
			}

			public String getAnnouncement() {
				return announcement;
			}

			public void setAnnouncement(String announcement) {
				this.announcement = announcement;
			}

			public String getUpdatetime() {
				return updatetime;
			}

			public void setUpdatetime(String updatetime) {
				this.updatetime = updatetime;
			}

			public String getChannelId() {
				return channelId;
			}

			public void setChannelId(String channelId) {
				this.channelId = channelId;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getVideo() {
				return video;
			}

			public void setVideo(String video) {
				this.video = video;
			}

			public String getSlug() {
				return slug;
			}

			public void setSlug(String slug) {
				this.slug = slug;
			}

			public String getCategory_id() {
				return category_id;
			}

			public void setCategory_id(String category_id) {
				this.category_id = category_id;
			}

			public String getCover() {
				return cover;
			}

			public void setCover(String cover) {
				this.cover = cover;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public String getRecommend_image() {
				return recommend_image;
			}

			public void setRecommend_image(String recommend_image) {
				this.recommend_image = recommend_image;
			}

			public String getWeight() {
				return weight;
			}

			public void setWeight(String weight) {
				this.weight = weight;
			}

			public String getStart_time() {
				return start_time;
			}

			public void setStart_time(String start_time) {
				this.start_time = start_time;
			}

			public String getCheck() {
				return check;
			}

			public void setCheck(String check) {
				this.check = check;
			}

			public String getPriv() {
				return priv;
			}

			public void setPriv(String priv) {
				this.priv = priv;
			}

			public String getCategory_name() {
				return category_name;
			}

			public void setCategory_name(String category_name) {
				this.category_name = category_name;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getSource() {
				return source;
			}

			public void setSource(String source) {
				this.source = source;
			}

			public String getLast_play_at() {
				return last_play_at;
			}

			public void setLast_play_at(String last_play_at) {
				this.last_play_at = last_play_at;
			}

			public String getLandscape() {
				return landscape;
			}

			public void setLandscape(String landscape) {
				this.landscape = landscape;
			}

			public String getView() {
				return view;
			}

			public void setView(String view) {
				this.view = view;
			}

			public String getApp_shuffling_image() {
				return app_shuffling_image;
			}

			public void setApp_shuffling_image(String app_shuffling_image) {
				this.app_shuffling_image = app_shuffling_image;
			}

			public String getRecommend_new_image() {
				return recommend_new_image;
			}

			public void setRecommend_new_image(String recommend_new_image) {
				this.recommend_new_image = recommend_new_image;
			}

			public String getCategoryId() {
				return categoryId;
			}

			public void setCategoryId(String categoryId) {
				this.categoryId = categoryId;
			}

			public boolean isHidden() {
				return hidden;
			}

			public void setHidden(boolean hidden) {
				this.hidden = hidden;
			}

			public boolean isPlay_status() {
				return play_status;
			}

			public void setPlay_status(boolean play_status) {
				this.play_status = play_status;
			}

			public String getLove_cover() {
				return love_cover;
			}

			public void setLove_cover(String love_cover) {
				this.love_cover = love_cover;
			}
		}
	}

	public static class AppFocusCheckBean {
		/**
		 * id : 621
		 * title : 2016赛季LSPL夏季赛
		 * thumb : http://image.quanmin.tv/aeee5525061499f449348654e76388bejpg
		 * link :
		 * create_at : 2016-04-29 16:35:02
		 * status : 1
		 * fk : 674228
		 * subtitle :
		 * content :
		 * ext : {"type":"play"}
		 * slot_id : 153
		 * priority : 0
		 * link_object : {"no":"674228","nick":"LSPL官方频道","avatar":"http://image.quanmin
		 * .tv/avatar/530d6327b39ebc3465476c750a2a7214jpg?imageView2/2/w/300/",
		 * "follow":"376220","id":"14042","uid":"674228","title":"LSPL夏季赛重播：季军&冠军赛 ",
		 * "category_id":"1","slug":"lspl","intro":"","announcement":"",
		 * "cover":"674228-1505906344-904.jpg","play_at":"2017-09-20 16:51:18",
		 * "last_play_at":"","view":"32580","views":"46","status":"2","priv":"0",
		 * "landscape":"1","position":"","weight":"0","check":"1",
		 * "recommend_image":"http://image.quanmin
		 * .tv/8b5b09ad48de5703910e491ead6b10a2jpg","videoQuality":"234",
		 * "category_name":"英雄联盟","screen":0,"start_time":"1505905976.029",
		 * "source":"ws","stream":"http://flv13.quanmin.tv/live/674228_L3.flv",
		 * "thumb":"http://image.quanmin.tv/aeee5525061499f449348654e76388bejpg",
		 * "video":"http://thumb.quanmin.tv/674228.mp4?t=1505906100","channelId":"0",
		 * "liveId":"21873295","updatetime":"2017-09-20 16:50:25","rectifyType":"0",
		 * "app_shuffling_image":"http://static01.quanmin
		 * .tv/201707/15003619278177aa7260a74aa24553a58d22f65927505.jpg",
		 * "recommend_new_image":"http://static01.quanmin
		 * .tv/201707/1500369292989ba9b26f402856246fdf0376e40e6e4cf.jpg",
		 * "categoryId":"1","hidden":false,"play_status":true,"love_cover":""}
		 */

		private int id;
		private String title;
		private String thumb;
		private String link;
		private String create_at;
		private int status;
		private String fk;
		private String subtitle;
		private String content;
		private ExtBeanXXX ext;
		private int slot_id;
		private int priority;
		private LinkObjectBeanX link_object;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getCreate_at() {
			return create_at;
		}

		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getFk() {
			return fk;
		}

		public void setFk(String fk) {
			this.fk = fk;
		}

		public String getSubtitle() {
			return subtitle;
		}

		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public ExtBeanXXX getExt() {
			return ext;
		}

		public void setExt(ExtBeanXXX ext) {
			this.ext = ext;
		}

		public int getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(int slot_id) {
			this.slot_id = slot_id;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public LinkObjectBeanX getLink_object() {
			return link_object;
		}

		public void setLink_object(LinkObjectBeanX link_object) {
			this.link_object = link_object;
		}

		public static class ExtBeanXXX {
			/**
			 * type : play
			 */

			private String type;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public static class LinkObjectBeanX {
			/**
			 * no : 674228
			 * nick : LSPL官方频道
			 * avatar : http://image.quanmin
			 * .tv/avatar/530d6327b39ebc3465476c750a2a7214jpg?imageView2/2/w/300/
			 * follow : 376220
			 * id : 14042
			 * uid : 674228
			 * title : LSPL夏季赛重播：季军&冠军赛
			 * category_id : 1
			 * slug : lspl
			 * intro :
			 * announcement :
			 * cover : 674228-1505906344-904.jpg
			 * play_at : 2017-09-20 16:51:18
			 * last_play_at :
			 * view : 32580
			 * views : 46
			 * status : 2
			 * priv : 0
			 * landscape : 1
			 * position :
			 * weight : 0
			 * check : 1
			 * recommend_image : http://image.quanmin
			 * .tv/8b5b09ad48de5703910e491ead6b10a2jpg
			 * videoQuality : 234
			 * category_name : 英雄联盟
			 * screen : 0
			 * start_time : 1505905976.029
			 * source : ws
			 * stream : http://flv13.quanmin.tv/live/674228_L3.flv
			 * thumb : http://image.quanmin.tv/aeee5525061499f449348654e76388bejpg
			 * video : http://thumb.quanmin.tv/674228.mp4?t=1505906100
			 * channelId : 0
			 * liveId : 21873295
			 * updatetime : 2017-09-20 16:50:25
			 * rectifyType : 0
			 * app_shuffling_image : http://static01.quanmin
			 * .tv/201707/15003619278177aa7260a74aa24553a58d22f65927505.jpg
			 * recommend_new_image : http://static01.quanmin
			 * .tv/201707/1500369292989ba9b26f402856246fdf0376e40e6e4cf.jpg
			 * categoryId : 1
			 * hidden : false
			 * play_status : true
			 * love_cover :
			 */

			private String no;
			private String nick;
			private String avatar;
			private String follow;
			private String id;
			private String uid;
			private String title;
			private String category_id;
			private String slug;
			private String intro;
			private String announcement;
			private String cover;
			private String play_at;
			private String last_play_at;
			private String view;
			private String views;
			private String status;
			private String priv;
			private String landscape;
			private String position;
			private String weight;
			private String check;
			private String recommend_image;
			private String videoQuality;
			private String category_name;
			private int screen;
			private String start_time;
			private String source;
			private String stream;
			private String thumb;
			private String video;
			private String channelId;
			private String liveId;
			private String updatetime;
			private String rectifyType;
			private String app_shuffling_image;
			private String recommend_new_image;
			private String categoryId;
			private boolean hidden;
			private boolean play_status;
			private String love_cover;

			public String getNo() {
				return no;
			}

			public void setNo(String no) {
				this.no = no;
			}

			public String getNick() {
				return nick;
			}

			public void setNick(String nick) {
				this.nick = nick;
			}

			public String getAvatar() {
				return avatar;
			}

			public void setAvatar(String avatar) {
				this.avatar = avatar;
			}

			public String getFollow() {
				return follow;
			}

			public void setFollow(String follow) {
				this.follow = follow;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getUid() {
				return uid;
			}

			public void setUid(String uid) {
				this.uid = uid;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getCategory_id() {
				return category_id;
			}

			public void setCategory_id(String category_id) {
				this.category_id = category_id;
			}

			public String getSlug() {
				return slug;
			}

			public void setSlug(String slug) {
				this.slug = slug;
			}

			public String getIntro() {
				return intro;
			}

			public void setIntro(String intro) {
				this.intro = intro;
			}

			public String getAnnouncement() {
				return announcement;
			}

			public void setAnnouncement(String announcement) {
				this.announcement = announcement;
			}

			public String getCover() {
				return cover;
			}

			public void setCover(String cover) {
				this.cover = cover;
			}

			public String getPlay_at() {
				return play_at;
			}

			public void setPlay_at(String play_at) {
				this.play_at = play_at;
			}

			public String getLast_play_at() {
				return last_play_at;
			}

			public void setLast_play_at(String last_play_at) {
				this.last_play_at = last_play_at;
			}

			public String getView() {
				return view;
			}

			public void setView(String view) {
				this.view = view;
			}

			public String getViews() {
				return views;
			}

			public void setViews(String views) {
				this.views = views;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public String getPriv() {
				return priv;
			}

			public void setPriv(String priv) {
				this.priv = priv;
			}

			public String getLandscape() {
				return landscape;
			}

			public void setLandscape(String landscape) {
				this.landscape = landscape;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position;
			}

			public String getWeight() {
				return weight;
			}

			public void setWeight(String weight) {
				this.weight = weight;
			}

			public String getCheck() {
				return check;
			}

			public void setCheck(String check) {
				this.check = check;
			}

			public String getRecommend_image() {
				return recommend_image;
			}

			public void setRecommend_image(String recommend_image) {
				this.recommend_image = recommend_image;
			}

			public String getVideoQuality() {
				return videoQuality;
			}

			public void setVideoQuality(String videoQuality) {
				this.videoQuality = videoQuality;
			}

			public String getCategory_name() {
				return category_name;
			}

			public void setCategory_name(String category_name) {
				this.category_name = category_name;
			}

			public int getScreen() {
				return screen;
			}

			public void setScreen(int screen) {
				this.screen = screen;
			}

			public String getStart_time() {
				return start_time;
			}

			public void setStart_time(String start_time) {
				this.start_time = start_time;
			}

			public String getSource() {
				return source;
			}

			public void setSource(String source) {
				this.source = source;
			}

			public String getStream() {
				return stream;
			}

			public void setStream(String stream) {
				this.stream = stream;
			}

			public String getThumb() {
				return thumb;
			}

			public void setThumb(String thumb) {
				this.thumb = thumb;
			}

			public String getVideo() {
				return video;
			}

			public void setVideo(String video) {
				this.video = video;
			}

			public String getChannelId() {
				return channelId;
			}

			public void setChannelId(String channelId) {
				this.channelId = channelId;
			}

			public String getLiveId() {
				return liveId;
			}

			public void setLiveId(String liveId) {
				this.liveId = liveId;
			}

			public String getUpdatetime() {
				return updatetime;
			}

			public void setUpdatetime(String updatetime) {
				this.updatetime = updatetime;
			}

			public String getRectifyType() {
				return rectifyType;
			}

			public void setRectifyType(String rectifyType) {
				this.rectifyType = rectifyType;
			}

			public String getApp_shuffling_image() {
				return app_shuffling_image;
			}

			public void setApp_shuffling_image(String app_shuffling_image) {
				this.app_shuffling_image = app_shuffling_image;
			}

			public String getRecommend_new_image() {
				return recommend_new_image;
			}

			public void setRecommend_new_image(String recommend_new_image) {
				this.recommend_new_image = recommend_new_image;
			}

			public String getCategoryId() {
				return categoryId;
			}

			public void setCategoryId(String categoryId) {
				this.categoryId = categoryId;
			}

			public boolean isHidden() {
				return hidden;
			}

			public void setHidden(boolean hidden) {
				this.hidden = hidden;
			}

			public boolean isPlay_status() {
				return play_status;
			}

			public void setPlay_status(boolean play_status) {
				this.play_status = play_status;
			}

			public String getLove_cover() {
				return love_cover;
			}

			public void setLove_cover(String love_cover) {
				this.love_cover = love_cover;
			}
		}
	}

	public static class IosfocusBean {
		/**
		 * title : 阿怡：王者一日游
		 * link : quanmin://mobile.app/liveroom?live=8832533
		 * fk : 8832533
		 * slot_id : 165
		 * ext : {"type":"play"}
		 * link_object : {"no":"8832533","nick":"阿怡丶全民","avatar":"http://a.img.shouyintv
		 * .cn/hnmx201-normal","follow":"766014","uid":"8832533","rectifyType":"0",
		 * "play_at":"2017-09-20 18:23:20","liveId":"21877663","screen":0,"danger":"0",
		 * "views":"2728","intro":"","videoQuality":"234","thumb":"http://image.quanmin
		 * .tv/2af345492a53f8fcde60a17936bdb066jpg","stream":"http://flv.quanmin
		 * .tv/live/8832533_L3.flv","position":"外太空","announcement":"",
		 * "updatetime":"2017-09-20 18:23:04","channelId":"0","id":"101398",
		 * "video":"http://thumb.quanmin.tv/8832533.mp4?t=1505906100","slug":"",
		 * "category_id":"17","cover":"8832533-1505906345-51.jpg","status":"2",
		 * "recommend_image":"http://image.quanmin
		 * .tv/68377681dd4e79a8292daaa3c4ee4b36jpg","weight":"0",
		 * "start_time":"1505903000.691","check":"1","priv":"0","category_name":"王者荣耀",
		 * "title":"阿怡：王者一日游","source":"ws","last_play_at":"","landscape":"1",
		 * "view":"490875","app_shuffling_image":"http://image.quanmin
		 * .tv/2af345492a53f8fcde60a17936bdb066jpg",
		 * "recommend_new_image":"http://static01.quanmin
		 * .tv/201707/1501497382110ae624b1ed5247d6a81314428b92a7964.jpg",
		 * "categoryId":"17","hidden":false,"play_status":true,"love_cover":""}
		 * thumb : http://image.quanmin.tv/2af345492a53f8fcde60a17936bdb066jpg
		 */

		private String title;
		private String link;
		private String fk;
		private int slot_id;
		private ExtBeanXXXX ext;
		private LinkObjectBeanXX link_object;
		private String thumb;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getFk() {
			return fk;
		}

		public void setFk(String fk) {
			this.fk = fk;
		}

		public int getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(int slot_id) {
			this.slot_id = slot_id;
		}

		public ExtBeanXXXX getExt() {
			return ext;
		}

		public void setExt(ExtBeanXXXX ext) {
			this.ext = ext;
		}

		public LinkObjectBeanXX getLink_object() {
			return link_object;
		}

		public void setLink_object(LinkObjectBeanXX link_object) {
			this.link_object = link_object;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public static class ExtBeanXXXX {
			/**
			 * type : play
			 */

			private String type;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public static class LinkObjectBeanXX {
			/**
			 * no : 8832533
			 * nick : 阿怡丶全民
			 * avatar : http://a.img.shouyintv.cn/hnmx201-normal
			 * follow : 766014
			 * uid : 8832533
			 * rectifyType : 0
			 * play_at : 2017-09-20 18:23:20
			 * liveId : 21877663
			 * screen : 0
			 * danger : 0
			 * views : 2728
			 * intro :
			 * videoQuality : 234
			 * thumb : http://image.quanmin.tv/2af345492a53f8fcde60a17936bdb066jpg
			 * stream : http://flv.quanmin.tv/live/8832533_L3.flv
			 * position : 外太空
			 * announcement :
			 * updatetime : 2017-09-20 18:23:04
			 * channelId : 0
			 * id : 101398
			 * video : http://thumb.quanmin.tv/8832533.mp4?t=1505906100
			 * slug :
			 * category_id : 17
			 * cover : 8832533-1505906345-51.jpg
			 * status : 2
			 * recommend_image : http://image.quanmin
			 * .tv/68377681dd4e79a8292daaa3c4ee4b36jpg
			 * weight : 0
			 * start_time : 1505903000.691
			 * check : 1
			 * priv : 0
			 * category_name : 王者荣耀
			 * title : 阿怡：王者一日游
			 * source : ws
			 * last_play_at :
			 * landscape : 1
			 * view : 490875
			 * app_shuffling_image : http://image.quanmin
			 * .tv/2af345492a53f8fcde60a17936bdb066jpg
			 * recommend_new_image : http://static01.quanmin
			 * .tv/201707/1501497382110ae624b1ed5247d6a81314428b92a7964.jpg
			 * categoryId : 17
			 * hidden : false
			 * play_status : true
			 * love_cover :
			 */

			private String no;
			private String nick;
			private String avatar;
			private String follow;
			private String uid;
			private String rectifyType;
			private String play_at;
			private String liveId;
			private int screen;
			private String danger;
			private String views;
			private String intro;
			private String videoQuality;
			private String thumb;
			private String stream;
			private String position;
			private String announcement;
			private String updatetime;
			private String channelId;
			private String id;
			private String video;
			private String slug;
			private String category_id;
			private String cover;
			private String status;
			private String recommend_image;
			private String weight;
			private String start_time;
			private String check;
			private String priv;
			private String category_name;
			private String title;
			private String source;
			private String last_play_at;
			private String landscape;
			private String view;
			private String app_shuffling_image;
			private String recommend_new_image;
			private String categoryId;
			private boolean hidden;
			private boolean play_status;
			private String love_cover;

			public String getNo() {
				return no;
			}

			public void setNo(String no) {
				this.no = no;
			}

			public String getNick() {
				return nick;
			}

			public void setNick(String nick) {
				this.nick = nick;
			}

			public String getAvatar() {
				return avatar;
			}

			public void setAvatar(String avatar) {
				this.avatar = avatar;
			}

			public String getFollow() {
				return follow;
			}

			public void setFollow(String follow) {
				this.follow = follow;
			}

			public String getUid() {
				return uid;
			}

			public void setUid(String uid) {
				this.uid = uid;
			}

			public String getRectifyType() {
				return rectifyType;
			}

			public void setRectifyType(String rectifyType) {
				this.rectifyType = rectifyType;
			}

			public String getPlay_at() {
				return play_at;
			}

			public void setPlay_at(String play_at) {
				this.play_at = play_at;
			}

			public String getLiveId() {
				return liveId;
			}

			public void setLiveId(String liveId) {
				this.liveId = liveId;
			}

			public int getScreen() {
				return screen;
			}

			public void setScreen(int screen) {
				this.screen = screen;
			}

			public String getDanger() {
				return danger;
			}

			public void setDanger(String danger) {
				this.danger = danger;
			}

			public String getViews() {
				return views;
			}

			public void setViews(String views) {
				this.views = views;
			}

			public String getIntro() {
				return intro;
			}

			public void setIntro(String intro) {
				this.intro = intro;
			}

			public String getVideoQuality() {
				return videoQuality;
			}

			public void setVideoQuality(String videoQuality) {
				this.videoQuality = videoQuality;
			}

			public String getThumb() {
				return thumb;
			}

			public void setThumb(String thumb) {
				this.thumb = thumb;
			}

			public String getStream() {
				return stream;
			}

			public void setStream(String stream) {
				this.stream = stream;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position;
			}

			public String getAnnouncement() {
				return announcement;
			}

			public void setAnnouncement(String announcement) {
				this.announcement = announcement;
			}

			public String getUpdatetime() {
				return updatetime;
			}

			public void setUpdatetime(String updatetime) {
				this.updatetime = updatetime;
			}

			public String getChannelId() {
				return channelId;
			}

			public void setChannelId(String channelId) {
				this.channelId = channelId;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getVideo() {
				return video;
			}

			public void setVideo(String video) {
				this.video = video;
			}

			public String getSlug() {
				return slug;
			}

			public void setSlug(String slug) {
				this.slug = slug;
			}

			public String getCategory_id() {
				return category_id;
			}

			public void setCategory_id(String category_id) {
				this.category_id = category_id;
			}

			public String getCover() {
				return cover;
			}

			public void setCover(String cover) {
				this.cover = cover;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public String getRecommend_image() {
				return recommend_image;
			}

			public void setRecommend_image(String recommend_image) {
				this.recommend_image = recommend_image;
			}

			public String getWeight() {
				return weight;
			}

			public void setWeight(String weight) {
				this.weight = weight;
			}

			public String getStart_time() {
				return start_time;
			}

			public void setStart_time(String start_time) {
				this.start_time = start_time;
			}

			public String getCheck() {
				return check;
			}

			public void setCheck(String check) {
				this.check = check;
			}

			public String getPriv() {
				return priv;
			}

			public void setPriv(String priv) {
				this.priv = priv;
			}

			public String getCategory_name() {
				return category_name;
			}

			public void setCategory_name(String category_name) {
				this.category_name = category_name;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getSource() {
				return source;
			}

			public void setSource(String source) {
				this.source = source;
			}

			public String getLast_play_at() {
				return last_play_at;
			}

			public void setLast_play_at(String last_play_at) {
				this.last_play_at = last_play_at;
			}

			public String getLandscape() {
				return landscape;
			}

			public void setLandscape(String landscape) {
				this.landscape = landscape;
			}

			public String getView() {
				return view;
			}

			public void setView(String view) {
				this.view = view;
			}

			public String getApp_shuffling_image() {
				return app_shuffling_image;
			}

			public void setApp_shuffling_image(String app_shuffling_image) {
				this.app_shuffling_image = app_shuffling_image;
			}

			public String getRecommend_new_image() {
				return recommend_new_image;
			}

			public void setRecommend_new_image(String recommend_new_image) {
				this.recommend_new_image = recommend_new_image;
			}

			public String getCategoryId() {
				return categoryId;
			}

			public void setCategoryId(String categoryId) {
				this.categoryId = categoryId;
			}

			public boolean isHidden() {
				return hidden;
			}

			public void setHidden(boolean hidden) {
				this.hidden = hidden;
			}

			public boolean isPlay_status() {
				return play_status;
			}

			public void setPlay_status(boolean play_status) {
				this.play_status = play_status;
			}

			public String getLove_cover() {
				return love_cover;
			}

			public void setLove_cover(String love_cover) {
				this.love_cover = love_cover;
			}
		}
	}

	public static class IosstarttestBean {
		/**
		 * id : 1572
		 * title : 和TA私奔到月亮
		 * thumb : http://image.quanmin.tv/a082375762e8e7081237261ae4477d0bjpg
		 * link : http://m.quanmin.tv/static/v2/m/boot/special/qmsd/join.html?a=123
		 * create_at : 2016-09-12 18:49:40
		 * status : 1
		 * fk :
		 * subtitle :
		 * content :
		 * ext : {"type":"html","time":"10","start_time":1479263065,
		 * "end_time":1480521600}
		 * slot_id : 236
		 * priority : 0
		 */

		private int id;
		private String title;
		private String thumb;
		private String link;
		private String create_at;
		private int status;
		private String fk;
		private String subtitle;
		private String content;
		private ExtBeanXXXXX ext;
		private int slot_id;
		private int priority;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getCreate_at() {
			return create_at;
		}

		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getFk() {
			return fk;
		}

		public void setFk(String fk) {
			this.fk = fk;
		}

		public String getSubtitle() {
			return subtitle;
		}

		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public ExtBeanXXXXX getExt() {
			return ext;
		}

		public void setExt(ExtBeanXXXXX ext) {
			this.ext = ext;
		}

		public int getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(int slot_id) {
			this.slot_id = slot_id;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public static class ExtBeanXXXXX {
			/**
			 * type : html
			 * time : 10
			 * start_time : 1479263065
			 * end_time : 1480521600
			 */

			private String type;
			private String time;
			private int start_time;
			private int end_time;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getTime() {
				return time;
			}

			public void setTime(String time) {
				this.time = time;
			}

			public int getStart_time() {
				return start_time;
			}

			public void setStart_time(int start_time) {
				this.start_time = start_time;
			}

			public int getEnd_time() {
				return end_time;
			}

			public void setEnd_time(int end_time) {
				this.end_time = end_time;
			}
		}
	}

	public static class IosfocustestBean {
		/**
		 * id : 1573
		 * title : 和TA私奔到月球
		 * thumb : http://image.quanmin.tv/11e294b92c2c08565aff1a78114aa136jpg
		 * link : http://m.quanmin.tv/static/v2/m/boot/special/qmsd/join.html
		 * create_at : 2016-09-12 18:51:13
		 * status : 1
		 * fk :
		 * subtitle :
		 * content :
		 * ext : {"type":"ad"}
		 * slot_id : 237
		 * priority : 0
		 * link_object : {"no":"8832533","nick":"阿怡丶全民","avatar":"http://a.img.shouyintv
		 * .cn/hnmx201-normal","follow":"766014","uid":"8832533","rectifyType":"0",
		 * "play_at":"2017-09-20 18:23:20","liveId":"21877663","screen":0,"danger":"0",
		 * "views":"2728","intro":"","videoQuality":"234","thumb":"",
		 * "stream":"http://flv.quanmin.tv/live/8832533_L3.flv","position":"外太空",
		 * "announcement":"","updatetime":"2017-09-20 18:23:04","channelId":"0",
		 * "id":"101398","video":"http://thumb.quanmin.tv/8832533.mp4?t=1505906100",
		 * "slug":"","category_id":"17","cover":"8832533-1505906345-51.jpg",
		 * "status":"2","recommend_image":"http://image.quanmin
		 * .tv/68377681dd4e79a8292daaa3c4ee4b36jpg","weight":"0",
		 * "start_time":"1505903000.691","check":"1","priv":"0","category_name":"王者荣耀",
		 * "title":"阿怡：王者一日游","source":"ws","last_play_at":"","landscape":"1",
		 * "view":"490875","app_shuffling_image":"http://image.quanmin
		 * .tv/2af345492a53f8fcde60a17936bdb066jpg",
		 * "recommend_new_image":"http://static01.quanmin
		 * .tv/201707/1501497382110ae624b1ed5247d6a81314428b92a7964.jpg",
		 * "categoryId":"17","hidden":false,"play_status":true,"love_cover":""}
		 */

		private int id;
		private String title;
		private String thumb;
		private String link;
		private String create_at;
		private int status;
		private String fk;
		private String subtitle;
		private String content;
		private ExtBeanXXXXXX ext;
		private int slot_id;
		private int priority;
		private LinkObjectBeanXXX link_object;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getCreate_at() {
			return create_at;
		}

		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getFk() {
			return fk;
		}

		public void setFk(String fk) {
			this.fk = fk;
		}

		public String getSubtitle() {
			return subtitle;
		}

		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public ExtBeanXXXXXX getExt() {
			return ext;
		}

		public void setExt(ExtBeanXXXXXX ext) {
			this.ext = ext;
		}

		public int getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(int slot_id) {
			this.slot_id = slot_id;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public LinkObjectBeanXXX getLink_object() {
			return link_object;
		}

		public void setLink_object(LinkObjectBeanXXX link_object) {
			this.link_object = link_object;
		}

		public static class ExtBeanXXXXXX {
			/**
			 * type : ad
			 */

			private String type;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public static class LinkObjectBeanXXX {
			/**
			 * no : 8832533
			 * nick : 阿怡丶全民
			 * avatar : http://a.img.shouyintv.cn/hnmx201-normal
			 * follow : 766014
			 * uid : 8832533
			 * rectifyType : 0
			 * play_at : 2017-09-20 18:23:20
			 * liveId : 21877663
			 * screen : 0
			 * danger : 0
			 * views : 2728
			 * intro :
			 * videoQuality : 234
			 * thumb :
			 * stream : http://flv.quanmin.tv/live/8832533_L3.flv
			 * position : 外太空
			 * announcement :
			 * updatetime : 2017-09-20 18:23:04
			 * channelId : 0
			 * id : 101398
			 * video : http://thumb.quanmin.tv/8832533.mp4?t=1505906100
			 * slug :
			 * category_id : 17
			 * cover : 8832533-1505906345-51.jpg
			 * status : 2
			 * recommend_image : http://image.quanmin
			 * .tv/68377681dd4e79a8292daaa3c4ee4b36jpg
			 * weight : 0
			 * start_time : 1505903000.691
			 * check : 1
			 * priv : 0
			 * category_name : 王者荣耀
			 * title : 阿怡：王者一日游
			 * source : ws
			 * last_play_at :
			 * landscape : 1
			 * view : 490875
			 * app_shuffling_image : http://image.quanmin
			 * .tv/2af345492a53f8fcde60a17936bdb066jpg
			 * recommend_new_image : http://static01.quanmin
			 * .tv/201707/1501497382110ae624b1ed5247d6a81314428b92a7964.jpg
			 * categoryId : 17
			 * hidden : false
			 * play_status : true
			 * love_cover :
			 */

			private String no;
			private String nick;
			private String avatar;
			private String follow;
			private String uid;
			private String rectifyType;
			private String play_at;
			private String liveId;
			private int screen;
			private String danger;
			private String views;
			private String intro;
			private String videoQuality;
			private String thumb;
			private String stream;
			private String position;
			private String announcement;
			private String updatetime;
			private String channelId;
			private String id;
			private String video;
			private String slug;
			private String category_id;
			private String cover;
			private String status;
			private String recommend_image;
			private String weight;
			private String start_time;
			private String check;
			private String priv;
			private String category_name;
			private String title;
			private String source;
			private String last_play_at;
			private String landscape;
			private String view;
			private String app_shuffling_image;
			private String recommend_new_image;
			private String categoryId;
			private boolean hidden;
			private boolean play_status;
			private String love_cover;

			public String getNo() {
				return no;
			}

			public void setNo(String no) {
				this.no = no;
			}

			public String getNick() {
				return nick;
			}

			public void setNick(String nick) {
				this.nick = nick;
			}

			public String getAvatar() {
				return avatar;
			}

			public void setAvatar(String avatar) {
				this.avatar = avatar;
			}

			public String getFollow() {
				return follow;
			}

			public void setFollow(String follow) {
				this.follow = follow;
			}

			public String getUid() {
				return uid;
			}

			public void setUid(String uid) {
				this.uid = uid;
			}

			public String getRectifyType() {
				return rectifyType;
			}

			public void setRectifyType(String rectifyType) {
				this.rectifyType = rectifyType;
			}

			public String getPlay_at() {
				return play_at;
			}

			public void setPlay_at(String play_at) {
				this.play_at = play_at;
			}

			public String getLiveId() {
				return liveId;
			}

			public void setLiveId(String liveId) {
				this.liveId = liveId;
			}

			public int getScreen() {
				return screen;
			}

			public void setScreen(int screen) {
				this.screen = screen;
			}

			public String getDanger() {
				return danger;
			}

			public void setDanger(String danger) {
				this.danger = danger;
			}

			public String getViews() {
				return views;
			}

			public void setViews(String views) {
				this.views = views;
			}

			public String getIntro() {
				return intro;
			}

			public void setIntro(String intro) {
				this.intro = intro;
			}

			public String getVideoQuality() {
				return videoQuality;
			}

			public void setVideoQuality(String videoQuality) {
				this.videoQuality = videoQuality;
			}

			public String getThumb() {
				return thumb;
			}

			public void setThumb(String thumb) {
				this.thumb = thumb;
			}

			public String getStream() {
				return stream;
			}

			public void setStream(String stream) {
				this.stream = stream;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position;
			}

			public String getAnnouncement() {
				return announcement;
			}

			public void setAnnouncement(String announcement) {
				this.announcement = announcement;
			}

			public String getUpdatetime() {
				return updatetime;
			}

			public void setUpdatetime(String updatetime) {
				this.updatetime = updatetime;
			}

			public String getChannelId() {
				return channelId;
			}

			public void setChannelId(String channelId) {
				this.channelId = channelId;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getVideo() {
				return video;
			}

			public void setVideo(String video) {
				this.video = video;
			}

			public String getSlug() {
				return slug;
			}

			public void setSlug(String slug) {
				this.slug = slug;
			}

			public String getCategory_id() {
				return category_id;
			}

			public void setCategory_id(String category_id) {
				this.category_id = category_id;
			}

			public String getCover() {
				return cover;
			}

			public void setCover(String cover) {
				this.cover = cover;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public String getRecommend_image() {
				return recommend_image;
			}

			public void setRecommend_image(String recommend_image) {
				this.recommend_image = recommend_image;
			}

			public String getWeight() {
				return weight;
			}

			public void setWeight(String weight) {
				this.weight = weight;
			}

			public String getStart_time() {
				return start_time;
			}

			public void setStart_time(String start_time) {
				this.start_time = start_time;
			}

			public String getCheck() {
				return check;
			}

			public void setCheck(String check) {
				this.check = check;
			}

			public String getPriv() {
				return priv;
			}

			public void setPriv(String priv) {
				this.priv = priv;
			}

			public String getCategory_name() {
				return category_name;
			}

			public void setCategory_name(String category_name) {
				this.category_name = category_name;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getSource() {
				return source;
			}

			public void setSource(String source) {
				this.source = source;
			}

			public String getLast_play_at() {
				return last_play_at;
			}

			public void setLast_play_at(String last_play_at) {
				this.last_play_at = last_play_at;
			}

			public String getLandscape() {
				return landscape;
			}

			public void setLandscape(String landscape) {
				this.landscape = landscape;
			}

			public String getView() {
				return view;
			}

			public void setView(String view) {
				this.view = view;
			}

			public String getApp_shuffling_image() {
				return app_shuffling_image;
			}

			public void setApp_shuffling_image(String app_shuffling_image) {
				this.app_shuffling_image = app_shuffling_image;
			}

			public String getRecommend_new_image() {
				return recommend_new_image;
			}

			public void setRecommend_new_image(String recommend_new_image) {
				this.recommend_new_image = recommend_new_image;
			}

			public String getCategoryId() {
				return categoryId;
			}

			public void setCategoryId(String categoryId) {
				this.categoryId = categoryId;
			}

			public boolean isHidden() {
				return hidden;
			}

			public void setHidden(boolean hidden) {
				this.hidden = hidden;
			}

			public boolean isPlay_status() {
				return play_status;
			}

			public void setPlay_status(boolean play_status) {
				this.play_status = play_status;
			}

			public String getLove_cover() {
				return love_cover;
			}

			public void setLove_cover(String love_cover) {
				this.love_cover = love_cover;
			}
		}
	}
}
