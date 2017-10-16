package com.yichen.mmq.bean;

import java.util.List;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class Recommend {

	private List<RoomBean> room;
	private List<?> ad;

	public List<RoomBean> getRoom() {
		return room;
	}

	public void setRoom(List<RoomBean> room) {
		this.room = room;
	}

	public List<?> getAd() {
		return ad;
	}

	public void setAd(List<?> ad) {
		this.ad = ad;
	}

	public static class RoomBean {
		/**
		 * id : 0
		 * name : 精彩推荐
		 * is_default : 1
		 * icon :
		 * slug :
		 * category_more :
		 * type : 1
		 * screen : 0
		 * list : [{"beauty_cover":"http://static01.quanmin
		 * .tv/201709/59fd1378-1ae3-496c-97ea-f5b2ca56c04b.jpg","no":3379226,
		 * "first_play_at":"1970-01-01 08:00:00","category_name":"王者荣耀","gender":-1,
		 * "thumb":"http://static01.quanmin
		 * .tv/201709/59fd1378-1ae3-496c-97ea-f5b2ca56c04b.jpg","oldNo":"",
		 * "room_tag":"","last_play_at":"1970-01-01 08:00:00","screen":0,
		 * "video":"http://thumb.quanmin.tv/1355221.mp4?t=1505906400","title":"【巅峰挑战赛】
		 * 16进8 谁主沉浮","recommend_image":"","is_shield":false,"nick":"超级酷乐ML",
		 * "uid":1355221,"view":"199444","category_id":17,"stream":"http://flv.quanmin
		 * .tv/live/1355221.flv","slug":null,"love_cover":"http://static01.quanmin
		 * .tv/201709/59fd1378-1ae3-496c-97ea-f5b2ca56c04b.jpg","level":0,"like":0,
		 * "video_quality":null,"weight":0,"starlight":2488,"check":true,
		 * "avatar":"http://a.img.shouyintv.cn/vKzf201-normal","follow":53954,
		 * "play_count":0,"play_true":0,"fans":0,"block_image":"","max_view":0,
		 * "default_image":"","last_end_at":"1970-01-01 08:00:00","position":"外太空",
		 * "create_at":"2017-09-20 17:01:04","last_thumb":"1355221-1505810285-525.jpg",
		 * "landscape":1,"category_slug":"wangzhe","anniversary":0,"play_status":true,
		 * "status":2,"cid":6,"coin":2488,"frame":"","link":"http://www.quanmin
		 * .tv/3379226"},{"beauty_cover":"","no":21493767,"first_play_at":"1970-01-01
		 * 08:00:00","category_name":"Showing","gender":0,"thumb":"http://a.img
		 * .shouyintv.cn/DyAr201-big","oldNo":"","room_tag":"",
		 * "last_play_at":"1970-01-01 08:00:00","screen":1,"video":"http://thumb.quanmin
		 * .tv/1138281580.mp4?t=1505906400","title":"主播70C 再问自杀","recommend_image":"",
		 * "is_shield":false,"nick":"板栗小姐姐","uid":1138281580,"view":"4281",
		 * "category_id":29,"stream":"http://flv.quanmin.tv/live/1138281580.flv",
		 * "slug":null,"love_cover":"","level":0,"like":0,"video_quality":null,
		 * "weight":0,"starlight":372359,"check":true,"avatar":"http://a.img.shouyintv
		 * .cn/DyAr201-normal","follow":7613,"play_count":0,"play_true":0,"fans":0,
		 * "block_image":"","max_view":0,"default_image":"","last_end_at":"1970-01-01
		 * 08:00:00","position":"成都市","create_at":"2017-09-20 18:57:28",
		 * "last_thumb":"1138281580-1505832847-245.jpg","landscape":0,
		 * "category_slug":"showing","anniversary":0,"play_status":true,"status":2,
		 * "cid":6,"coin":372359,"frame":"","link":"http://www.quanmin.tv/21493767"},
		 * {"beauty_cover":"http://static01.quanmin
		 * .tv/201709/9da3622b-4113-4d98-8640-3fee7b6ab2ac.png","no":13272672,
		 * "first_play_at":"1970-01-01 08:00:00","category_name":"全民星秀","gender":0,
		 * "thumb":"http://static01.quanmin
		 * .tv/201709/9da3622b-4113-4d98-8640-3fee7b6ab2ac.png","oldNo":"",
		 * "room_tag":"","last_play_at":"1970-01-01 08:00:00","screen":0,
		 * "video":"http://thumb.quanmin.tv/1331290406.mp4?t=1505906400",
		 * "title":"carry凯睿女生宿舍","recommend_image":"","is_shield":false,
		 * "nick":"carry凯睿","uid":1331290406,"view":"3830","category_id":4,
		 * "stream":"http://flv.quanmin.tv/live/1331290406.flv","slug":null,
		 * "love_cover":"http://static01.quanmin
		 * .tv/201709/9da3622b-4113-4d98-8640-3fee7b6ab2ac.png","level":0,"like":0,
		 * "video_quality":null,"weight":0,"starlight":45681,"check":true,
		 * "avatar":"http://a.img.shouyintv.cn/0SQt201-normal","follow":2380,
		 * "play_count":0,"play_true":0,"fans":0,"block_image":"","max_view":0,
		 * "default_image":"","last_end_at":"1970-01-01 08:00:00","position":"外太空",
		 * "create_at":"2017-09-20 15:44:22",
		 * "last_thumb":"1331290406-1505125409-202.jpg","landscape":1,
		 * "category_slug":"beauty","anniversary":0,"play_status":true,"status":2,
		 * "cid":6,"coin":45681,"frame":"","link":"http://www.quanmin.tv/13272672"},
		 * {"beauty_cover":"","no":16213410,"first_play_at":"1970-01-01 08:00:00",
		 * "category_name":"枪火游侠","gender":1,"thumb":"http://snap.quanmin
		 * .tv/2084162428-1505906557-824.jpg?imageView2/2/w/390/","oldNo":"",
		 * "room_tag":"","last_play_at":"1970-01-01 08:00:00","screen":0,
		 * "video":"http://thumb.quanmin.tv/2084162428.mp4?t=1505906400",
		 * "title":"趣式醉脚巴克，巴克本人来到直播间","recommend_image":"","is_shield":false,
		 * "nick":"小趣","uid":2084162428,"view":"11236","category_id":53,
		 * "stream":"http://flv.quanmin.tv/live/2084162428_L3.flv","slug":"xiaoqu",
		 * "love_cover":"","level":0,"like":0,"video_quality":"234","weight":0,
		 * "starlight":6390,"check":true,"avatar":"http://a.img.shouyintv
		 * .cn/AURf201-normal","follow":1467,"play_count":0,"play_true":0,"fans":0,
		 * "block_image":"","max_view":0,"default_image":"","last_end_at":"1970-01-01
		 * 08:00:00","position":"外太空","create_at":"2017-09-20 17:57:49",
		 * "last_thumb":"2084162428-1505829579-450.jpg","landscape":1,
		 * "category_slug":"qianghuoyouxia","anniversary":0,"play_status":true,
		 * "status":2,"cid":6,"coin":6390,"frame":"","link":"http://www.quanmin
		 * .tv/v/xiaoqu"},{"first_play_at":"1970-01-01 08:00:00","category_name":"全民户外",
		 * "oldNo":"","room_tag":"","recommend_new_image":"http://static01.quanmin
		 * .tv/201709/0d7e967d-8c56-4ab2-869f-fe79255a9c2c.jpg","screen":0,
		 * "view":"6380","slug":null,"love_cover":"","level":0,"like":0,
		 * "video_quality":null,"weight":0,"starlight":21398,"check":true,
		 * "play_count":0,"play_true":0,"block_image":"","default_image":"",
		 * "position":"外太空","status":2,"cid":6,"coin":21398,"frame":"",
		 * "beauty_cover":"","no":14320575,"gender":0,"thumb":"http://snap.quanmin
		 * .tv/1541275176-1505906525-900.jpg?imageView2/2/w/390/",
		 * "last_play_at":"1970-01-01 08:00:00","video":"http://thumb.quanmin
		 * .tv/1541275176.mp4?t=1505906400","title":"瑜伽 健身",
		 * "recommend_image":"http://static01.quanmin
		 * .tv/201708/349cd6d9-a670-4112-8f0e-dbe9beadcea9.jpg","is_shield":false,
		 * "nick":"蕾拉小姐","uid":1541275176,"category_id":13,"stream":"http://flv.quanmin
		 * .tv/live/1541275176.flv","avatar":"http://a.img.shouyintv.cn/6ECi202-normal",
		 * "follow":31949,"fans":0,"max_view":0,"last_end_at":"1970-01-01 08:00:00",
		 * "app_shuffling_image":"http://static01.quanmin
		 * .tv/201709/a3b3a9a2-fb70-4d9c-a3a2-bd0186989f85.jpg","create_at":"2017-09-20
		 * 17:56:05","last_thumb":"1541275176-1505038805-182.jpg","landscape":1,
		 * "category_slug":"huwai","anniversary":0,"play_status":true,"link":"http://www
		 * .quanmin.tv/14320575"},{"beauty_cover":"","no":17341623,
		 * "first_play_at":"1970-01-01 08:00:00","category_name":"绝地求生","gender":1,
		 * "thumb":"http://snap.quanmin
		 * .tv/1551467056-1505906525-942.jpg?imageView2/2/w/390/","oldNo":"",
		 * "room_tag":"","last_play_at":"1970-01-01 08:00:00","screen":0,
		 * "video":"http://thumb.quanmin.tv/1551467056.mp4?t=1505906400",
		 * "title":"PUBG香蕉计划国际邀请赛","recommend_image":"","is_shield":false,
		 * "nick":"香蕉计划活动专房","uid":1551467056,"view":"71579","category_id":68,
		 * "stream":"http://flv.quanmin.tv/live/1551467056.flv","slug":null,
		 * "love_cover":"","level":0,"like":0,"video_quality":null,"weight":0,
		 * "starlight":0,"check":true,"avatar":"http://a.img.shouyintv
		 * .cn/otnW201-normal","follow":63192,"play_count":0,"play_true":0,"fans":0,
		 * "block_image":"","max_view":0,"default_image":"","last_end_at":"1970-01-01
		 * 08:00:00","position":"外太空","create_at":"2017-09-20 18:43:53",
		 * "last_thumb":"1551467056-1499586725-287.jpg","landscape":1,
		 * "category_slug":"juediqiusheng","anniversary":0,"play_status":true,
		 * "status":2,"cid":6,"coin":0,"frame":"","link":"http://www.quanmin
		 * .tv/17341623"}]
		 */

		private int id;
		private String name;
		private int is_default;
		private String icon;
		private String slug;
		private String category_more;
		private int type;
		private int screen;
		private List<ListBean> list;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIs_default() {
			return is_default;
		}

		public void setIs_default(int is_default) {
			this.is_default = is_default;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getSlug() {
			return slug;
		}

		public void setSlug(String slug) {
			this.slug = slug;
		}

		public String getCategory_more() {
			return category_more;
		}

		public void setCategory_more(String category_more) {
			this.category_more = category_more;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public int getScreen() {
			return screen;
		}

		public void setScreen(int screen) {
			this.screen = screen;
		}

		public List<ListBean> getList() {
			return list;
		}

		public void setList(List<ListBean> list) {
			this.list = list;
		}

		public static class ListBean {
			/**
			 * beauty_cover : http://static01.quanmin
			 * .tv/201709/59fd1378-1ae3-496c-97ea-f5b2ca56c04b.jpg
			 * no : 3379226
			 * first_play_at : 1970-01-01 08:00:00
			 * category_name : 王者荣耀
			 * gender : -1
			 * thumb : http://static01.quanmin
			 * .tv/201709/59fd1378-1ae3-496c-97ea-f5b2ca56c04b.jpg
			 * oldNo :
			 * room_tag :
			 * last_play_at : 1970-01-01 08:00:00
			 * screen : 0
			 * video : http://thumb.quanmin.tv/1355221.mp4?t=1505906400
			 * title : 【巅峰挑战赛】 16进8 谁主沉浮
			 * recommend_image :
			 * is_shield : false
			 * nick : 超级酷乐ML
			 * uid : 1355221
			 * view : 199444
			 * category_id : 17
			 * stream : http://flv.quanmin.tv/live/1355221.flv
			 * slug : null
			 * love_cover : http://static01.quanmin
			 * .tv/201709/59fd1378-1ae3-496c-97ea-f5b2ca56c04b.jpg
			 * level : 0
			 * like : 0
			 * video_quality : null
			 * weight : 0
			 * starlight : 2488
			 * check : true
			 * avatar : http://a.img.shouyintv.cn/vKzf201-normal
			 * follow : 53954
			 * play_count : 0
			 * play_true : 0
			 * fans : 0
			 * block_image :
			 * max_view : 0
			 * default_image :
			 * last_end_at : 1970-01-01 08:00:00
			 * position : 外太空
			 * create_at : 2017-09-20 17:01:04
			 * last_thumb : 1355221-1505810285-525.jpg
			 * landscape : 1
			 * category_slug : wangzhe
			 * anniversary : 0
			 * play_status : true
			 * status : 2
			 * cid : 6
			 * coin : 2488
			 * frame :
			 * link : http://www.quanmin.tv/3379226
			 * recommend_new_image : http://static01.quanmin
			 * .tv/201709/0d7e967d-8c56-4ab2-869f-fe79255a9c2c.jpg
			 * app_shuffling_image : http://static01.quanmin
			 * .tv/201709/a3b3a9a2-fb70-4d9c-a3a2-bd0186989f85.jpg
			 */

			private String beauty_cover;
			private int no;
			private String first_play_at;
			private String category_name;
			private int gender;
			private String thumb;
			private String oldNo;
			private String room_tag;
			private String last_play_at;
			private int screen;
			private String video;
			private String title;
			private String recommend_image;
			private boolean is_shield;
			private String nick;
			private int uid;
			private String view;
			private int category_id;
			private String stream;
			private Object slug;
			private String love_cover;
			private int level;
			private int like;
			private Object video_quality;
			private int weight;
			private int starlight;
			private boolean check;
			private String avatar;
			private int follow;
			private int play_count;
			private int play_true;
			private int fans;
			private String block_image;
			private int max_view;
			private String default_image;
			private String last_end_at;
			private String position;
			private String create_at;
			private String last_thumb;
			private int landscape;
			private String category_slug;
			private int anniversary;
			private boolean play_status;
			private int status;
			private int cid;
			private int coin;
			private String frame;
			private String link;
			private String recommend_new_image;
			private String app_shuffling_image;

			public String getBeauty_cover() {
				return beauty_cover;
			}

			public void setBeauty_cover(String beauty_cover) {
				this.beauty_cover = beauty_cover;
			}

			public int getNo() {
				return no;
			}

			public void setNo(int no) {
				this.no = no;
			}

			public String getFirst_play_at() {
				return first_play_at;
			}

			public void setFirst_play_at(String first_play_at) {
				this.first_play_at = first_play_at;
			}

			public String getCategory_name() {
				return category_name;
			}

			public void setCategory_name(String category_name) {
				this.category_name = category_name;
			}

			public int getGender() {
				return gender;
			}

			public void setGender(int gender) {
				this.gender = gender;
			}

			public String getThumb() {
				return thumb;
			}

			public void setThumb(String thumb) {
				this.thumb = thumb;
			}

			public String getOldNo() {
				return oldNo;
			}

			public void setOldNo(String oldNo) {
				this.oldNo = oldNo;
			}

			public String getRoom_tag() {
				return room_tag;
			}

			public void setRoom_tag(String room_tag) {
				this.room_tag = room_tag;
			}

			public String getLast_play_at() {
				return last_play_at;
			}

			public void setLast_play_at(String last_play_at) {
				this.last_play_at = last_play_at;
			}

			public int getScreen() {
				return screen;
			}

			public void setScreen(int screen) {
				this.screen = screen;
			}

			public String getVideo() {
				return video;
			}

			public void setVideo(String video) {
				this.video = video;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getRecommend_image() {
				return recommend_image;
			}

			public void setRecommend_image(String recommend_image) {
				this.recommend_image = recommend_image;
			}

			public boolean isIs_shield() {
				return is_shield;
			}

			public void setIs_shield(boolean is_shield) {
				this.is_shield = is_shield;
			}

			public String getNick() {
				return nick;
			}

			public void setNick(String nick) {
				this.nick = nick;
			}

			public int getUid() {
				return uid;
			}

			public void setUid(int uid) {
				this.uid = uid;
			}

			public String getView() {
				return view;
			}

			public void setView(String view) {
				this.view = view;
			}

			public int getCategory_id() {
				return category_id;
			}

			public void setCategory_id(int category_id) {
				this.category_id = category_id;
			}

			public String getStream() {
				return stream;
			}

			public void setStream(String stream) {
				this.stream = stream;
			}

			public Object getSlug() {
				return slug;
			}

			public void setSlug(Object slug) {
				this.slug = slug;
			}

			public String getLove_cover() {
				return love_cover;
			}

			public void setLove_cover(String love_cover) {
				this.love_cover = love_cover;
			}

			public int getLevel() {
				return level;
			}

			public void setLevel(int level) {
				this.level = level;
			}

			public int getLike() {
				return like;
			}

			public void setLike(int like) {
				this.like = like;
			}

			public Object getVideo_quality() {
				return video_quality;
			}

			public void setVideo_quality(Object video_quality) {
				this.video_quality = video_quality;
			}

			public int getWeight() {
				return weight;
			}

			public void setWeight(int weight) {
				this.weight = weight;
			}

			public int getStarlight() {
				return starlight;
			}

			public void setStarlight(int starlight) {
				this.starlight = starlight;
			}

			public boolean isCheck() {
				return check;
			}

			public void setCheck(boolean check) {
				this.check = check;
			}

			public String getAvatar() {
				return avatar;
			}

			public void setAvatar(String avatar) {
				this.avatar = avatar;
			}

			public int getFollow() {
				return follow;
			}

			public void setFollow(int follow) {
				this.follow = follow;
			}

			public int getPlay_count() {
				return play_count;
			}

			public void setPlay_count(int play_count) {
				this.play_count = play_count;
			}

			public int getPlay_true() {
				return play_true;
			}

			public void setPlay_true(int play_true) {
				this.play_true = play_true;
			}

			public int getFans() {
				return fans;
			}

			public void setFans(int fans) {
				this.fans = fans;
			}

			public String getBlock_image() {
				return block_image;
			}

			public void setBlock_image(String block_image) {
				this.block_image = block_image;
			}

			public int getMax_view() {
				return max_view;
			}

			public void setMax_view(int max_view) {
				this.max_view = max_view;
			}

			public String getDefault_image() {
				return default_image;
			}

			public void setDefault_image(String default_image) {
				this.default_image = default_image;
			}

			public String getLast_end_at() {
				return last_end_at;
			}

			public void setLast_end_at(String last_end_at) {
				this.last_end_at = last_end_at;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position;
			}

			public String getCreate_at() {
				return create_at;
			}

			public void setCreate_at(String create_at) {
				this.create_at = create_at;
			}

			public String getLast_thumb() {
				return last_thumb;
			}

			public void setLast_thumb(String last_thumb) {
				this.last_thumb = last_thumb;
			}

			public int getLandscape() {
				return landscape;
			}

			public void setLandscape(int landscape) {
				this.landscape = landscape;
			}

			public String getCategory_slug() {
				return category_slug;
			}

			public void setCategory_slug(String category_slug) {
				this.category_slug = category_slug;
			}

			public int getAnniversary() {
				return anniversary;
			}

			public void setAnniversary(int anniversary) {
				this.anniversary = anniversary;
			}

			public boolean isPlay_status() {
				return play_status;
			}

			public void setPlay_status(boolean play_status) {
				this.play_status = play_status;
			}

			public int getStatus() {
				return status;
			}

			public void setStatus(int status) {
				this.status = status;
			}

			public int getCid() {
				return cid;
			}

			public void setCid(int cid) {
				this.cid = cid;
			}

			public int getCoin() {
				return coin;
			}

			public void setCoin(int coin) {
				this.coin = coin;
			}

			public String getFrame() {
				return frame;
			}

			public void setFrame(String frame) {
				this.frame = frame;
			}

			public String getLink() {
				return link;
			}

			public void setLink(String link) {
				this.link = link;
			}

			public String getRecommend_new_image() {
				return recommend_new_image;
			}

			public void setRecommend_new_image(String recommend_new_image) {
				this.recommend_new_image = recommend_new_image;
			}

			public String getApp_shuffling_image() {
				return app_shuffling_image;
			}

			public void setApp_shuffling_image(String app_shuffling_image) {
				this.app_shuffling_image = app_shuffling_image;
			}
		}
	}
}
