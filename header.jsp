						<!------- Side Header --------->
						<div class="col-2">
							<!--<div>
								<a href="index.do" class=" 
							 	mt-3 d-none d-lg-block" >
									<img src="static/images/logo.png" class="m-1 py-2 px-3" id="logo">
								</a>
							</div>-->
							<div class="menu_container mt-3">
								<div class="menu py-2 ">
									<a href="index.do"class="menu_links">
										<i class="fa fa-home menu_icons "></i>
										<span class="d-none
										d-lg-inline-block menu_messages ">Home</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="inbox.do" class="menu_links">
										<i class="fa fa-commenting menu_icons"></i>
										<span class="d-none
										d-lg-inline-block menu_messages">Message</span>
									</a>
								</div>
								<div class="menu py-sm-2">
									<a href="all_notification.do" class="menu_links">
										<i class="fa fa-bell menu_icons">
											
										</i>
										<span id="notfication_text_seperate" class="menu_messages d-none
										d-lg-inline-block">Notifications</span>
										<span id="all_count_notify" class="float-right">
											
										</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="user_profile.do" class="menu_links">
										<i class="fa fa-user menu_icons"></i>
										<span class="d-none
										d-lg-inline-block menu_messages">Profile</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="" class="menu_links">
										<i class="fa fa-gear menu_icons"></i>
										<span class="menu_messages d-none
										d-lg-inline-block">Settings</span>
									</a>
								</div>
								<!--<div class="menu py-2 d-none d-lg-inline-block">
									<a href="logout_user.do" class="menu_links">
										<i class="fa fa-sign-out menu_icons"></i>
										<span class="menu_messages">Logout</span>
									</a>
								</div>-->
							</div>
							<hr>
							<div class="head_text_label d-none d-lg-inline-block px-3">
								<span>Account</span>
							</div>
							<div class="session_user d-none d-lg-inline-block mx-2 mt-3">
								<div class="mt-3">
									<img src="show_profile_pic.do" class="session_user_image"/>
									<span class="ml-0 session_user_nm">
										${user.userName}
									</span>
								</div>
							</div>
						</div>