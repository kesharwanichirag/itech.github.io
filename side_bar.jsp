						<!--#### Side Bar ####-->
						<input type="hidden" value="${user.city.cityId}" name="city_id" id="city_id">

						<input type="hidden" value="${user.userId}" id="user_user_id">

					 	<div class="col-3 d-none d-lg-block " id="side_bar_cont">
							<div class="search_box mt-4">
								<div id="search_bar">
									<input type="text" name="search_user" id="search" placeholder="Search..">
									
									
									<div class="py-2" id="srch_res">
										
									</div>

									<button id="search_button">
									
										<i onclick="startDictation()" class="fa fa-microphone">
											
										</i>
									</button>
									<span id="spinner_loader">
										<img src="static/images/loader.jpg"
										 style="height: 22px;">
									</span>
								</div>
							</div>
							<!---- Suggession User ----->
							<div class="mt-3 suggession_box">
								<div class="d-inline-block head_text_label px-3 p-2">
									<span>
										Suggestions For You
									</span>
									<!--<div class="d-inline-block feed_active">
										<a href="" class="feed_active">
											See All
										</a>
									</div>-->
									<div class="mt-3" id="sg_users_box">
										
									</div>
								</div>
							</div>
							<!---- Suggession User End ----->
							<!--- News Section --->
							<div class="pages_box">
								<div class=" head_text_label px-3 p-2">
									My Pages
									<!--<div class="d-inline-block feed_active float-right">
										<a href="" class="feed_active">
											See More Pages..
										</a>
									</div>-->				
								</div>
								<div id="pages_container" class="pages_container mt-2 d-block">
									
								</div>
							</div>
							<!--- News Section End --->
							<!--- Footer --->
							<div class="footer_section float-bottom mt-2 mb-2">
								<a href="" class="footer_links">About</a>
								<a href="" class="footer_links">Help</a>
								<a href="" class="footer_links">Terms</a>
								<a href="" class="footer_links">Contact</a>
							</div>
							<!--- Footer End --->
						</div>
						<!--#### Side Bar End ####-->
						