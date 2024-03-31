package com.ifs21034.gmail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.ifs21034.gmail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView() {
        binding.navView.setCheckedItem(R.id.nav_inbox)

        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)

        loadFragment(FLAG_FRAGMENT_DASHBOARD)
    }

    private fun setupAction() {
        binding.inAppBar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_profile -> {
                    val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> true
            }
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_inbox -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_primary -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Primary!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_promotions -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Promotions!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_social -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Social!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_starred -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Starred!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_snoozed -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Snoozed!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_important -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Snoozed!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_sent -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Sent!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_scheduled -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Sent!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_drafts -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Outbox!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_all_inboxes -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Outbox!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_spam -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Trash!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_trash -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Trash!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_calendar -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Calendar!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_contacts -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Contacts!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_settings -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Settings!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_help -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Help!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else -> true
            }
        }

        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_mail -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD)
                    true
                }
                R.id.navigation_Meet -> {
                    loadFragment(FLAG_FRAGMENT_NOTIFICATION)
                    true
                }

                else -> true
            }
        }
    }

    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id

        when (flag) {

            FLAG_FRAGMENT_DASHBOARD -> {
                val dashboardFragment = DashboardFragment()
                val fragment = fragmentManager .findFragmentByTag(DashboardFragment::class.java.simpleName)

                if (fragment !is DashboardFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            dashboardFragment,
                            DashboardFragment::class.java.simpleName
                        )
                        .commit()
                }
            }

            FLAG_FRAGMENT_NOTIFICATION -> {
                val notificationFragment = NotificationFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(NotificationFragment::class.java.simpleName)

                if (fragment !is NotificationFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            notificationFragment,
                            NotificationFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
        }
    }

    companion object {
        const val FLAG_FRAGMENT_DASHBOARD = "fragment_dashboard"
        const val FLAG_FRAGMENT_NOTIFICATION = "fragment_notification"
    }

}
